package uflycn.com.customtilelayer.map;

import com.esri.arcgisruntime.arcgisservices.TileInfo;
import com.esri.arcgisruntime.data.TileKey;
import com.esri.arcgisruntime.geometry.Envelope;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.internal.jni.CoreWebTiledLayer;
import com.esri.arcgisruntime.layers.ServiceImageTiledLayer;
import com.esri.arcgisruntime.layers.WebTiledLayer;

public class GaodeMapLayer extends WebTiledLayer {

    private double[] scales = new double[]{5.91657527591555E8D, 2.95828763795777E8D, 1.47914381897889E8D,
            7.3957190948944E7D, 3.6978595474472E7D, 1.8489297737236E7D, 9244648.868618D, 4622324.434309D,
            2311162.217155D, 1155581.108577D, 577790.554289D, 288895.277144D, 144447.638572D, 72223.819286D,
            36111.909643D, 18055.954822D, 9027.977411D, 4513.988705D, 2256.994353D, 1128.497176D, 564.248588D,
            282.124294D, 141.062147D, 70.5310735D};
    private double[] resolutions = new double[]{156543.03392800014D, 78271.51696399994D, 39135.75848200009D,
            19567.87924099992D, 9783.93962049996D, 4891.96981024998D, 2445.98490512499D, 1222.992452562495D, 611.49622628138D,
            305.748113140558D, 152.874056570411D, 76.4370282850732D, 38.2185141425366D, 19.1092570712683D, 9.55462853563415D,
            4.77731426794937D, 2.388657133974685D, 1.1943285668550503D, 0.5971642835598172D, 0.29858214164761665D,
            0.1492910708238083D, 0.0746455354119042D, 0.0373227677059521D, 0.0186613838529761D};
    private Point origin = new Point(-2.0037508342787E7D, 2.0037508342787E7D);


    public GaodeMapLayer(String templateUri) {
        super(templateUri);
    }

    public GaodeMapLayer(String templateUri, Iterable<String> subDomains) {
        super(templateUri, subDomains);
    }

    public GaodeMapLayer(String templateUri, TileInfo tileInfo, Envelope fullExtent) {
        super(templateUri, tileInfo, fullExtent);
    }

    public GaodeMapLayer(String templateUri, Iterable<String> subDomains, TileInfo tileInfo, Envelope fullExtent) {
        super(templateUri, subDomains, tileInfo, fullExtent);
    }

    protected GaodeMapLayer(CoreWebTiledLayer coreWebTiledLayer, boolean addToCache) {
        super(coreWebTiledLayer, addToCache);
    }


}
