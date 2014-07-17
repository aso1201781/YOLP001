package jp.ac.st.asojuku.yolp001;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapController;
import jp.co.yahoo.android.maps.MapView;
import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity implements LocationListener {

	
	
	
	

	LocationManager mLocationManager = null;
	MapView mMapView = null;
	int lastLatitude = 0;
	int lastLongitude = 0;
	
	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		
		mMapView = new MapView(this,"TdhZ1hERlB4QU01ViZzPWNvbnN1bWVyc2VjcmV0Jng9Mjgdj0zaiZpPTdhZ1hERlB4QU01ViZzPWNvbnN1bWVyc2VjcmV0Jng9Mjg-");
		mMapView.setBuiltInZoomControls(true);
		mMapView.setScalebar(true);
		
		double lat = 35.658516;
		double lon = 139.701773;
		GeoPoint gp = new GeoPoint((int)(lat * 1000000),(int)(lon * 1000000));
		MapController c = mMapView.getMapController();
		
		c.setCenter(gp);
		c.setZoom(3);
		setContentView(mMapView);
		
		mLocationManager =
				(LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		String provider = mLocationManager.getBestProvider(criteria,true);
		mLocationManager.requestLocationUpdates(provider,0,0,this);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO 自動生成されたメソッド・スタブ
				double lat = location.getLatitude();
				int latitude = (int)(lat * 1000000);
				double lon = location.getLatitude();
				int longitude = (int)(lon * 1000000);
				if(latitude/1000 != this.lastLatitude/1000 || longitude/1000 != this.lastLongitude/1000){
					GeoPoint gp = new GeoPoint(latitude,longitude);
					MapController c = mMapView.getMapController();
					c.setCenter(gp);
					this.lastLatitude = latitude;
					this.lastLongitude = longitude;
				}
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
