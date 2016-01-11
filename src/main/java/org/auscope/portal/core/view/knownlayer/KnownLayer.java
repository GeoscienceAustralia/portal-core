package org.auscope.portal.core.view.knownlayer;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A known layer is a grouping of CSWRecords representing some form of logical similarity that the registry couldn't provide.
 *
 * eg - A grouping of all CSWRecords that represent Earth Resource ML deployments
 *
 * @author Josh Vote
 *
 */
public class KnownLayer implements Serializable {
    private final Log logger = LogFactory.getLog(getClass().getName());

    /** auto generated version ID */
    private static final long serialVersionUID = 236524163668910226L;

    /** The name/title. */
    private String name;

    /** The description. */
    private String description;

    /** The id. */
    private String id;

    /** The hidden layer flag. */
    private boolean hidden;

    /** The layers group. */
    private String group;

    /** URL to proxy data requests through */
    private String proxyUrl;

    /** URL to proxy data count requests through */
    private String proxyCountUrl;

    /** URL to proxy data style requests through */
    private String proxyStyleUrl;

    /** URL to proxy download requests through */
    private String proxyDownloadUrl;

    /** Class for selecting CSWRecords that belong to this known layer */
    private KnownLayerSelector knownLayerSelector;

    /** If this layer is rendered, this icon will be used to mark any point geometries */
    private String iconUrl;

    /** If this layer is rendered, this color will be used for any polygon in the renderings */
    private String polygonColor;

    /** If this layer is rendered, this is the offset in pixels of where iconUrl will be anchored to the map */
    private Point iconAnchor;

    /** This is the size of point icon in pixels */
    private Dimension iconSize;

    private int feature_count;

    /** Set an order - defaults to name */
    private String order;

    /**
     * Creates a new KnownLayer
     *
     * @param id
     *            the unique ID for this layer (if null will be autogenerated using an internal static counter)
     * @param knownLayerSelector
     *            how this known layer will select CSW records
     */
    public KnownLayer(String id, KnownLayerSelector knownLayerSelector) {
        this.knownLayerSelector = knownLayerSelector;
        this.id = id;
    }

    /**
     * Gets the id.
     *
     * @return the id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the human readable name/title of this layer.
     *
     * @return the title
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the human readable name/title of this layer.
     * 
     * @param title
     *            the title to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the human readable description of this layer.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the human readable description of this layer.
     * 
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get whether this layer should be hidden and not available for selection.
     *
     * @return true, if is hidden
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Set whether this layer should by default be hidden and not available for selection.
     *
     * @param hidden
     *            the new hidden
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Gets the group for this known layer. Layers will be organised according to their group names.
     *
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the group for this known layer. Layers will be organised according to their group names.
     *
     * @param group
     *            the new group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Gets the URL to proxy data requests through
     * 
     * @return
     */
    public String getProxyUrl() {
        return proxyUrl;
    }

    /**
     * Sets the URL to proxy data requests through
     * 
     * @param proxyUrl
     */
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    /**
     * Gets the URL to proxy data count requests through
     * 
     * @return
     */
    public String getProxyCountUrl() {
        return proxyCountUrl;
    }

    /**
     * Sets the URL to proxy data count requests through
     * 
     * @param proxyCountUrl
     */
    public void setProxyCountUrl(String proxyCountUrl) {
        this.proxyCountUrl = proxyCountUrl;
    }

    /**
     * Sets the URL to proxy style requests through
     * 
     * @param proxyUrl
     */
    public void setProxyStyleUrl(String proxyStyleUrl) {
        this.proxyStyleUrl = proxyStyleUrl;
    }

    /**
     * Gets the URL to proxy style requests through
     * 
     * @return
     */
    public String getProxyStyleUrl() {
        return proxyStyleUrl;
    }

    /**
     * Sets the URL to proxy download requests through
     * 
     * @param proxyUrl
     */
    public void setProxyDownloadUrl(String proxyDownloadUrl) {
        this.proxyDownloadUrl = proxyDownloadUrl;
    }

    /**
     * Gets the URL to proxy download requests through
     * 
     * @return
     */
    public String getProxyDownloadUrl() {
        return this.proxyDownloadUrl;
    }

    /**
     * Gets the selector for this known layer
     * 
     * @return
     */
    public KnownLayerSelector getKnownLayerSelector() {
        return knownLayerSelector;
    }

    /**
     * Sets the selector for this known layer
     * 
     * @param knownLayerSelector
     */
    public void setKnownLayerSelector(KnownLayerSelector knownLayerSelector) {
        this.knownLayerSelector = knownLayerSelector;
    }

    /**
     * Gets the URL of an icon used to mark any point geometries
     * 
     * @return
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * Sets the URL of an icon used to mark any point geometries
     * 
     * @param iconUrl
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * Gets the color of a polygon used to mark any polygon geometries
     * 
     * @return
     */
    public String getPolygonColor() {
        return this.polygonColor;
    }

    /**
     * Sets the color of a polygon used to mark any polygon geometries
     * 
     * @param iconUrl
     */
    public void setPolygonColor(String polygonColor) {
        this.polygonColor = polygonColor;
    }

    /**
     * Gets the offset in pixels of the location where the icon will be anchored to the map
     * 
     * @return
     */
    public Point getIconAnchor() {
        return iconAnchor;
    }

    /**
     * Sets the offset in pixels of the location where the icon will be anchored to the map
     * 
     * @param iconAnchor
     */
    public void setIconAnchor(Point iconAnchor) {
        this.iconAnchor = iconAnchor;
    }

    /**
     * Gets the size of the icon in pixels
     * 
     * @return
     */
    public Dimension getIconSize() {
        return iconSize;
    }

    /**
     * Sets the size of the icon in pixels
     * 
     * @param iconSize
     */
    public void setIconSize(Dimension iconSize) {
        this.iconSize = iconSize;
    }

    public int getFeature_count() {
        return feature_count;
    }

    public void setFeature_count(int feature_count) {
        this.feature_count = feature_count;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
    	this.order = (order == null) ? "" : order;
        logger.info(String.format("setOrder - group: %s, name: %s, order: %s", getGroup(), getName(), getOrder()));
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "KnownLayer [name=" + name + ", id=" + id + ", description=" + description + ", hidden=" + hidden
                + ", group=" + group + ", proxyUrl=" + proxyUrl + ", proxyCountUrl=" + proxyCountUrl
                + ", proxyStyleUrl=" + proxyStyleUrl + ", proxyDownloadUrl=" + proxyDownloadUrl
                + ", knownLayerSelector=" + knownLayerSelector + ", iconUrl=" + iconUrl + ", polygonColor="
                + polygonColor + ", iconAnchor=" + iconAnchor + ", iconSize=" + iconSize + ", feature_count="
                + feature_count + ", order=" + order + "]";
    }
}
