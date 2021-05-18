package de.abiegel.configuration.osgi.liferay.configuration.form.renderer;

import java.util.ArrayList;
import java.util.List;

public class VocabularyConfigurationDisplayContext {

    private final List<String[]> vocabularies = new ArrayList<>();
    private String fieldLabel;
    private long currentVocabularyId;

    /**
     * Adds a vocabulary to a string array to be used in the configuration .jsp file
     *
     * @param vocabularyId   a string representing the id of the category
     * @param vocabularyName a string with the name of the category
     */
    public void addVocabulary(
        String vocabularyId, String vocabularyName) {
        vocabularies.add(new String[]{
            vocabularyId,
            vocabularyName
        });
    }

    /**
     * Gets the id of the currently selected vocabulary
     *
     * @return a long type id of the currently selected vocabulary
     */
    public long getCurrentVocabularyId() {
        return currentVocabularyId;
    }

    /**
     * Sets the id of the currently selected vocabulary
     *
     * @param vocId a long type id of the currently selected vocabulary
     */
    public void setCurrentVocabularyId(long vocId) {
        currentVocabularyId = vocId;
    }

    /**
     * Gets a string to be shown as label in the configuration .jsp file
     *
     * @return a string representing the label of the selector
     */
    public String getFieldLabel() {
        return fieldLabel;
    }

    /**
     * Sets a string to be shown as label in the configuration .jsp file
     *
     * @param fieldLabel a string representing the label of the selector
     */
    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    /**
     * Gets a list with the vocabularies of the global site of the portal
     *
     * @return a list with the vocabularies of the global site of the portal
     */
    public List<String[]> getVocabularies() {
        return vocabularies;
    }
}
