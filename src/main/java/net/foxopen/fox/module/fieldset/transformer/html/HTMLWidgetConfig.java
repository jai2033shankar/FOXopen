package net.foxopen.fox.module.fieldset.transformer.html;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration options for an HTML widget, including a link to the associated HTMLTransformConfig which should be used
 * when converting the resultant value from the HTML widget into a DOM. This provides a link between the options which
 * appear in the HTML widget and the tag names which are allowed by the HTMLTransformConfig.
 */
public class HTMLWidgetConfig {

  public static final String STANDARD_NAME = "standard";
  public static final String EXPANDED_NAME = "expanded";

  private static final String STANDARD_TOOLBAR = "bold italic underline | alignleft aligncenter alignright alignjustify | paste pastetext | code";
  private static final String EXPANDED_TOOLBAR = "undo redo | bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | paste pastetext | " +
    "bullist numlist | subscript superscript | code";

  private static final String DEFAULT_ADDITIONAL_CONFIG =
    "entities: \"8211,#45,8212,#45,8216,apos,8217,apos,8220,quot,8221,quot,160,nbsp,163,#163,8364,#8364\",\n" +
    "menubar: false,\n" +
    "statusbar: false,\n" +
    "inline_styles: false";

  private final HTMLTransformConfig mHTMLTransformConfig;

  private final String mAdditionalPlugins;
  private final String mToolbarConfig;
  private final String mAdditionalConfig;

  public static Map<String, HTMLWidgetConfig> engineDefaults() {
    Map<String, HTMLWidgetConfig> lDefaultMap = new HashMap<>();
    lDefaultMap.put(STANDARD_NAME, new HTMLWidgetConfig(HTMLTransformConfig.DEFAULT_STANDARD_INSTANCE, "", STANDARD_TOOLBAR, DEFAULT_ADDITIONAL_CONFIG));
    lDefaultMap.put(EXPANDED_NAME, new HTMLWidgetConfig(HTMLTransformConfig.DEFAULT_EXPANDED_INSTANCE, "", EXPANDED_TOOLBAR, DEFAULT_ADDITIONAL_CONFIG));
    return lDefaultMap;
  }

  public HTMLWidgetConfig(HTMLTransformConfig pHTMLTransformConfig, String pAdditionalPlugins, String pToolbarConfig, String pAdditionalConfig) {
    mHTMLTransformConfig = pHTMLTransformConfig;
    mAdditionalPlugins = pAdditionalPlugins;
    mToolbarConfig = pToolbarConfig;
    mAdditionalConfig = pAdditionalConfig;
  }

  /**
   * Gets the HTMLTransformConfig which should be used to process the resultant HTML generated by a widget with this WidgetConfig.
   * @return
   */
  public HTMLTransformConfig getHTMLTransformConfig() {
    return mHTMLTransformConfig;
  }

  /**
   * Gets a comma-separated list of plugins which TinyMCE should load, in addition to the engine defaults.
   * @return
   */
  public String getAdditionalPlugins() {
    return mAdditionalPlugins;
  }

  /**
   * Gets the JSON property value for the "toolbar" config property. This should be a valid JavaScript string in the TinyMCE toolbar config format.
   * E.g. "undo redo | bold italic"<br><br>
   * See http://www.tinymce.com/wiki.php/Configuration:toolbar
   * @return
   */
  public String getToolbarConfig() {
    return mToolbarConfig;
  }

  /**
   * Gets a block of JSON containing additional properties for TinyMCE which are not hardcoded in the engine. These
   * options are placed at the end of the TinyMCE configuration initialiser. This must be a valid JSON fragment, e.g.
   * <code>toolbar: false, statusbar: true</code>.<br><br>
   * See http://www.tinymce.com/wiki.php/Configuration
   * @return
   */
  public String getAdditionalConfig() {
    return mAdditionalConfig;
  }
}
