 package uflycn.com.customtilelayer;

 import android.Manifest;
 import android.content.pm.PackageManager;
 import android.os.Build;
 import android.os.Bundle;
 import android.support.annotation.NonNull;
 import android.support.v4.app.ActivityCompat;
 import android.support.v4.content.ContextCompat;
 import android.support.v7.app.AppCompatActivity;
 import android.widget.Toast;

 import com.esri.arcgisruntime.geometry.GeometryEngine;
 import com.esri.arcgisruntime.geometry.Point;
 import com.esri.arcgisruntime.layers.ArcGISSceneLayer;
 import com.esri.arcgisruntime.layers.FeatureLayer;
 import com.esri.arcgisruntime.layers.WebTiledLayer;
 import com.esri.arcgisruntime.mapping.ArcGISScene;
 import com.esri.arcgisruntime.mapping.Basemap;
 import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
 import com.esri.arcgisruntime.mapping.view.SceneView;

 import esrichina.hymn.Methods.TianDiTuMethodsClass;

public class MainActivity extends AppCompatActivity {
    private int requestCode = 2;
    String[] reqPermissions = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    private SceneView MainSceneView;
    private ArcGISScene MainArcGISScene;
    private ArcGISSceneLayer MainArcGISSceneLayer;
    private GraphicsOverlay MainGraphicsOverlay;
    private FeatureLayer ChinaFeatureLayer;
    private GraphicsOverlay MainChinaGraphicsOverlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkSDKVersion();
    }
    private void checkSDKVersion() {
        if (Build.VERSION.SDK_INT >= 23) {
            boolean resultPermission = true;
            for (String mpermission : reqPermissions
                    ) {
                boolean getted = ContextCompat.checkSelfPermission(this, mpermission) ==
                        PackageManager.PERMISSION_GRANTED;
                if (getted == false) {
                    resultPermission = false;
                }
            }
            if (resultPermission == false) {
                // If permissions are not already granted, request permission from the user.
                ActivityCompat.requestPermissions(this, reqPermissions, requestCode);
            } else {
                start();
            }
        } else {
            start();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Location permission was granted. This would have been triggered in response to failing to start the
            // LocationDisplay, so try starting this again.
            start();
        } else {
            Toast.makeText(this, "您需要同意相关权限！", Toast.LENGTH_LONG).show();
        }
    }
    private void start(){
        //三维场景中使用 需要墨卡托 投影的坐标
        MainSceneView = (SceneView) findViewById(R.id.sceneview);
        ArcGISScene arcGISScene = new ArcGISScene();
        WebTiledLayer webTiledLayer = TianDiTuMethodsClass.CreateTianDiTuTiledLayer(TianDiTuMethodsClass.LayerType.TIANDITU_VECTOR_MERCATOR);
        Basemap tdtBasemap = new Basemap(webTiledLayer);
       /* WebTiledLayer webTiledLayer1 = TianDiTuMethodsClass.CreateTianDiTuTiledLayer(TianDiTuMethodsClass.LayerType.TIANDITU_VECTOR_ANNOTATION_CHINESE_MERCATOR);
        tdtBasemap.getBaseLayers().add(webTiledLayer1);*/

        WebTiledLayer webTiledLayer2 = TianDiTuMethodsClass.CreateTianDiTuTiledLayer(TianDiTuMethodsClass.LayerType.TIANDITU_TERRAIN_ANNOTATION_CHINESE_MERCATOR);
        tdtBasemap.getBaseLayers().add(webTiledLayer2);

        arcGISScene.setBasemap(tdtBasemap);
        MainSceneView.setScene(arcGISScene);
        MainSceneView.setAttributionTextVisible(false);
    }




}
