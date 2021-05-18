package de.abiegel.configuration.osgi.liferay.configuration.form.renderer;

import static de.abiegel.configuration.osgi.liferay.configuration.form.renderer.constants.VocabularyConfigurationKeys.CONFIGURATION_NAME;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.configuration.admin.display.ConfigurationFormRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * ConfigurationFormRenderer to render a custom display for the country configuration
 */
@Component(
    immediate = true,
    service = ConfigurationFormRenderer.class
)
public class VocabularyConfigurationFormRenderer implements ConfigurationFormRenderer {

    private static final Log log = LogFactoryUtil.getLog(VocabularyConfigurationFormRenderer.class);
    @Reference
    private AssetVocabularyLocalService assetVocabularyLocalService;
    @Reference
    private JSPRenderer jspRenderer;
    @Reference
    private ConfigurationProvider configurationProvider;
    @Reference(
        target = "(osgi.web.symbolicname=de.abiegel.configuration.osgi.liferay.configuration.form.renderer)",
        unbind = "-"
    )
    private ServletContext _servletContext;

    /**
     * Returns the pid of the configuration
     *
     * @return a string with the pid of the configuration
     */
    @Override
    public String getPid() {
        return CONFIGURATION_NAME;
    }

    /**
     * Returns the parameter fetch from the HttpServletRequest
     *
     * @param httpServletRequest HttpServletRequest of the request
     *
     * @return a map with the parameter obtain from the HttpServletRequest
     */
    @Override
    public Map<String, Object> getRequestParameters(HttpServletRequest httpServletRequest) {
        Map<String, Object> params = new HashMap<>();
        String countryVocabulary = ParamUtil.getString(httpServletRequest, "vocabulary");
        params.put("vocabulary", countryVocabulary);
        return params;
    }

    /**
     * Renders and saves the chosen configuration. Gets the original configuration through a configuration provider with the save values if there is any. Sets a
     * list with the vocabularies of the global site And sets a display context object with the values to the request
     *
     * @param httpServletRequest  HttpServletRequest of the request
     * @param httpServletResponse HttpServletResponse of the response
     *
     * @throws IOException
     */
    @Override
    public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        VocabularyConfiguration countryConfiguration = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Locale locale = themeDisplay.getLocale();
        VocabularyConfigurationDisplayContext
            countryConfigurationDisplayContext =
            new VocabularyConfigurationDisplayContext();
        try {
            countryConfiguration = configurationProvider.getCompanyConfiguration(VocabularyConfiguration.class, themeDisplay.getCompanyId());
            long currentVocabularyId = countryConfiguration.vocabulary();
            countryConfigurationDisplayContext.setCurrentVocabularyId(currentVocabularyId);
    
        } catch (ConfigurationException e) {
            System.out.println(e);
            log.debug("Error getting instance configuration: ", e);
        }
        List<AssetVocabulary> vocabularies = null;
        try {
            vocabularies = assetVocabularyLocalService.getGroupVocabularies(themeDisplay.getCompanyGroupId());
        } catch (PortalException e) {
            log.debug("Error getting company vocabularies: ", e);
            System.out.println(e);
        }
        if (Validator.isNotNull(vocabularies) && !vocabularies.isEmpty()) {
            for (AssetVocabulary vocabulary : vocabularies) {
                countryConfigurationDisplayContext.addVocabulary(
                    String.valueOf(vocabulary.getVocabularyId()), vocabulary.getTitle(locale));
            }
        }
        countryConfigurationDisplayContext.setFieldLabel("vocabulary-label");
        httpServletRequest.setAttribute("countryConfigurationDisplayContext", countryConfigurationDisplayContext);
        jspRenderer.renderJSP(
            _servletContext, httpServletRequest, httpServletResponse,
            "/configuration.jsp");
    }
}
