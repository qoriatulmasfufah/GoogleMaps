package id.sch.smktelkom_mlg.learn.googlemaps.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import id.sch.smktelkom_mlg.learn.googlemaps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceMarkerFragment extends Fragment implements OnMapReadyCallback {

    static final CameraPosition KNDL = CameraPosition.builder()
            .target(new LatLng(-7.567328, 111.277135))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions rmh;
    MarkerOptions kntr;
    MarkerOptions puskesmas;
    MarkerOptions sekolah;
    MarkerOptions polres;
    MarkerOptions alun2;

    public PlaceMarkerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_marker, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int imageresources = getResources().getIdentifier("@drawable/ic_location_on_black_24dp", "drawable", getActivity().getPackageName());

        rmh = new MarkerOptions()
                .position(new LatLng(-7.567328, 111.277135))
                .title("My House")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        kntr = new MarkerOptions()
                .position(new LatLng(-7.568132, 111.288240))
                .title("Kantor")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        puskesmas = new MarkerOptions()
                .position(new LatLng(-7.536296, 111.248582))
                .title("Puskesmas Kendal")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        sekolah = new MarkerOptions()
                .position(new LatLng(-7.559236, 111.288869))
                .title("SMP 1 Kendal")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        polres = new MarkerOptions()
                .position(new LatLng(-7.399480, 111.446321))
                .title("Polres Ngawi")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        alun2 = new MarkerOptions()
                .position(new LatLng(-7.402921, 111.444668))
                .title("Alun-alun Ngawi")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(rmh);
        m_map.addMarker(kntr);
        m_map.addMarker(puskesmas);
        m_map.addMarker(sekolah);
        m_map.addMarker(polres);
        m_map.addMarker(alun2);
        flyTo(KNDL);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
