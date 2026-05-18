package de.abiegel.configuration.options;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.liferay.asset.auto.tagger.text.extractor.TextExtractor;
import com.liferay.asset.auto.tagger.text.extractor.TextExtractorRegistry;
import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.configuration.admin.definition.ConfigurationFieldOptionsProvider;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 *  @see https://github.com/liferay/liferay-portal/blob/master/modules/apps/asset/asset-auto-tagger-service/src/main/java/com/liferay/asset/auto/tagger/internal/configuration/admin/definition/EnabledClassNamesConfigurationFieldOptionsProvider.java
 */
@Component(property = { "configuration.field.name=entryList",
        "configuration.pid=de.abiegel.configuration.osgi.company.CompanyConfiguredComponentConfig"
         }, service = ConfigurationFieldOptionsProvider.class)
public class MyConfigurationFieldOptionsProvider implements ConfigurationFieldOptionsProvider {

    @Reference
    private TextExtractorRegistry  _textExtractorTracker;

    @Override
    public List<Option> getOptions() {
        List<AssetRendererFactory<?>> assetRendererFactories = AssetRendererFactoryRegistryUtil
                .getAssetRendererFactories(CompanyThreadLocal.getCompanyId());

        Stream<AssetRendererFactory<?>> stream = assetRendererFactories.stream();

        return stream.filter(assetRendererFactory -> {
            TextExtractor<?> textExtractor = _textExtractorTracker
                    .getTextExtractor(assetRendererFactory.getClassName());

            return textExtractor != null;
        }).map(assetRendererFactory -> new Option() {

            @Override
            public String getLabel(Locale locale) {
                return assetRendererFactory.getTypeName(locale);
            }

            @Override
            public String getValue() {
                return assetRendererFactory.getClassName();
            }

        }).collect(Collectors.toList());
    }

}
