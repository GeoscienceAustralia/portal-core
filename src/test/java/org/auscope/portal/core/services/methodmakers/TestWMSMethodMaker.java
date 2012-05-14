package org.auscope.portal.core.services.methodmakers;

import org.apache.commons.httpclient.HttpMethodBase;
import org.auscope.portal.core.services.methodmakers.WMSMethodMaker;
import org.auscope.portal.core.test.PortalTestClass;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for WMSMethodMaker
 * @author Josh Vote
 *
 */
public class TestWMSMethodMaker extends PortalTestClass {

    /**
     * Tests that the basic parameters make it into every request
     */
    @Test
    public void testParamParsing_NoParams() {
        WMSMethodMaker mm = new WMSMethodMaker();
        HttpMethodBase getCapMethod = mm.getCapabilitiesMethod("http://example.com");
        HttpMethodBase getFeatureMethod = mm.getFeatureInfo("http://example.com", "format", "layer", "EPSG:4326", 1.0, 2.0, 3.0, 4.0, 100, 200, 6.0, 7.0, 20, 30, "styles");
        HttpMethodBase getMapMethod = mm.getMapMethod("http://example.com", "layer", "imageMimeType", "srs", 1.0, 2.0, 3.0, 4.0, 100, 200, "styles", "styleBody");
        HttpMethodBase getLegendMethod = mm.getLegendGraphic("http://example.com", "layerName", 100, 200, "styles");

        Assert.assertTrue(getCapMethod.getQueryString().contains("service=WMS"));
        Assert.assertTrue(getCapMethod.getQueryString().contains("request=GetCapabilities"));

        Assert.assertTrue(getFeatureMethod.getQueryString().contains("service=WMS"));
        Assert.assertTrue(getFeatureMethod.getQueryString().contains("request=GetFeatureInfo"));

        Assert.assertTrue(getMapMethod.getQueryString().contains("service=WMS"));
        Assert.assertTrue(getMapMethod.getQueryString().contains("request=GetMap"));

        Assert.assertTrue(getLegendMethod.getQueryString().contains("service=WMS"));
        Assert.assertTrue(getLegendMethod.getQueryString().contains("request=GetLegendGraphic"));
    }

    /**
     * Tests that additional parameters make it into every request
     */
    @Test
    public void testParamParsing_ExtraParams() {
        WMSMethodMaker mm = new WMSMethodMaker();
        HttpMethodBase getCapMethod = mm.getCapabilitiesMethod("http://example.com?param1=val1&param2=val2");
        HttpMethodBase getFeatureMethod = mm.getFeatureInfo("http://example.com?param1=val1&param2=val2", "format", "layer", "EPSG:4326", 1.0, 2.0, 3.0, 4.0, 100, 200, 6.0, 7.0, 20, 30, "styles");
        HttpMethodBase getMapMethod = mm.getMapMethod("http://example.com?param1=val1&param2=val2", "layer", "imageMimeType", "srs", 1.0, 2.0, 3.0, 4.0, 100, 200, "styles", "styleBody");
        HttpMethodBase getLegendMethod = mm.getLegendGraphic("http://example.com?param1=val1&param2=val2", "layerName", 100, 200, "styles");

        Assert.assertTrue(getCapMethod.getQueryString().contains("service=WMS"));
        Assert.assertTrue(getCapMethod.getQueryString().contains("request=GetCapabilities"));
        Assert.assertTrue(getCapMethod.getQueryString().contains("param1=val1"));
        Assert.assertTrue(getCapMethod.getQueryString().contains("param2=val2"));

        Assert.assertTrue(getFeatureMethod.getQueryString().contains("service=WMS"));
        Assert.assertTrue(getFeatureMethod.getQueryString().contains("request=GetFeatureInfo"));
        Assert.assertTrue(getFeatureMethod.getQueryString().contains("param1=val1"));
        Assert.assertTrue(getFeatureMethod.getQueryString().contains("param2=val2"));

        Assert.assertTrue(getMapMethod.getQueryString().contains("service=WMS"));
        Assert.assertTrue(getMapMethod.getQueryString().contains("request=GetMap"));
        Assert.assertTrue(getMapMethod.getQueryString().contains("param1=val1"));
        Assert.assertTrue(getMapMethod.getQueryString().contains("param2=val2"));

        Assert.assertTrue(getLegendMethod.getQueryString().contains("service=WMS"));
        Assert.assertTrue(getLegendMethod.getQueryString().contains("request=GetLegendGraphic"));
        Assert.assertTrue(getLegendMethod.getQueryString().contains("param1=val1"));
        Assert.assertTrue(getLegendMethod.getQueryString().contains("param2=val2"));
    }
}
