package org.passinhos.passinhos;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import cz.msebera.android.httpclient.Header;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private View supportMapFragment;
    private GoogleMap mMap;
    private Location loc;
    private View v;

    final String LOCATIONS_DUMMY = "[{\"data\":{\"co_cnes\":\"6664253\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"10565000000192\",\"razao_social_mantenedora\":\"PREFEITURA DA CIDADE DO RECIFE\",\"no_razao_social\":\"PREFEITURA DA CIDADE DO RECIFE\",\"no_fantasia\":\"US 356 ACADEMIA DA CIDADE POLO ILHA DO LEITE\",\"ds_tipo_unidade\":\"POLO ACADEMIA DA SAUDE\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"PRACA MIGUEL DE CERVANTES\",\"nu_endereco\":\"S/N\",\"no_bairro\":\"ILHA DO LEITE\",\"co_cep\":\"50070120\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"(81) 33552820/2812\",\"ds_turno_atendimento\":\"ATENDIMENTO NOS TURNOS DA MANHA, TARDE E NOITE\",\"ds_servico_especializado\":\"ATENCAO BASICA\",\"lat\":\"-8.12769\",\"long\":\"-34.90851\",\"origem_coord\":\"CNES_GEO\"},\"distance\":110},{\"data\":{\"co_cnes\":\"3494578\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"\",\"razao_social_mantenedora\":\"\",\"no_razao_social\":\"PATRICIA MORAES GESTEIRA\",\"no_fantasia\":\"PATRICIA MORAES GESTEIRA\",\"ds_tipo_unidade\":\"CONSULTORIO ISOLADO\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"RUA DESEMBARGADOR JOAO PAES\",\"nu_endereco\":\"197\",\"no_bairro\":\"BOA VIAGEM\",\"co_cep\":\"51021360\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"(81)33255625\",\"ds_turno_atendimento\":\"ATENDIMENTOS NOS TURNOS DA MANHA E A TARDE\",\"ds_servico_especializado\":\"SERVICO DE DIAGNOSTICO POR IMAGEM\",\"lat\":\"-8.1264\",\"long\":\"-34.90815\",\"origem_coord\":\"CNES_GEO\"},\"distance\":256},{\"data\":{\"co_cnes\":\"3500667\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"\",\"razao_social_mantenedora\":\"\",\"no_razao_social\":\"BLENALY DE ARAUJO CRUZ\",\"no_fantasia\":\"BLENALY DE ARAUJO CRUZ\",\"ds_tipo_unidade\":\"CONSULTORIO ISOLADO\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"RUA DESEMBARGADOR JOAO PAES\",\"nu_endereco\":\"197\",\"no_bairro\":\"BOA VIAGEM\",\"co_cep\":\"51021360\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"(81)33255132\",\"ds_turno_atendimento\":\"ATENDIMENTOS NOS TURNOS DA MANHA E A TARDE\",\"ds_servico_especializado\":\"SERVICO DE DIAGNOSTICO POR IMAGEM\",\"lat\":\"-8.1264\",\"long\":\"-34.90815\",\"origem_coord\":\"CNES_GEO\"},\"distance\":256},{\"data\":{\"co_cnes\":\"6223869\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"\",\"razao_social_mantenedora\":\"\",\"no_razao_social\":\"LAURO SERGIO SILVA ACCIOLY\",\"no_fantasia\":\"LAURO SERGIO SILVA ACCIOLY\",\"ds_tipo_unidade\":\"CONSULTORIO ISOLADO\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"RUA DESEMBARGADOR JOAO PAES\",\"nu_endereco\":\"197\",\"no_bairro\":\"BOA VIAGEM\",\"co_cep\":\"51021360\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"8133264335\",\"ds_turno_atendimento\":\"ATENDIMENTOS NOS TURNOS DA MANHA E A TARDE\",\"ds_servico_especializado\":\"\",\"lat\":\"-8.12638\",\"long\":\"-34.90815\",\"origem_coord\":\"CNES_GEO\"},\"distance\":259},{\"data\":{\"co_cnes\":\"6222374\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"\",\"razao_social_mantenedora\":\"\",\"no_razao_social\":\"CONSULTORIO ODONTOLOGICO N E M SAUDE LTDA ME\",\"no_fantasia\":\"CONSULTORIO SAUDE\",\"ds_tipo_unidade\":\"CLINICA/CENTRO DE ESPECIALIDADE\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"RUA DESEMBARGADOR JOAO PAES\",\"nu_endereco\":\"197\",\"no_bairro\":\"BOA VIAGEM\",\"co_cep\":\"51021360\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"8130752959\",\"ds_turno_atendimento\":\"ATENDIMENTOS NOS TURNOS DA MANHA E A TARDE\",\"ds_servico_especializado\":\"\",\"lat\":\"-8.12638\",\"long\":\"-34.90815\",\"origem_coord\":\"CNES_GEO\"},\"distance\":259},{\"data\":{\"co_cnes\":\"5867428\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"\",\"razao_social_mantenedora\":\"\",\"no_razao_social\":\"EUDORO DE QUEIROZ MARQUES FILHO\",\"no_fantasia\":\"EUDORO DE QUEIROZ MARQUES FILHO\",\"ds_tipo_unidade\":\"CONSULTORIO ISOLADO\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"CARLOS PEREIRA FALCAO\",\"nu_endereco\":\"298\",\"no_bairro\":\"BOA VIAGEM\",\"co_cep\":\"51021350\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"8130825504\",\"ds_turno_atendimento\":\"ATENDIMENTOS NOS TURNOS DA MANHA E A TARDE\",\"ds_servico_especializado\":\"\",\"lat\":\"-8.12801\",\"long\":\"-34.90558\",\"origem_coord\":\"CNES_GEO\"},\"distance\":338},{\"data\":{\"co_cnes\":\"5161460\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"\",\"razao_social_mantenedora\":\"\",\"no_razao_social\":\"MARIA DE LOURDES MORAES ARAGAO\",\"no_fantasia\":\"MARIA DE LOURDES MORAES ARAGAO\",\"ds_tipo_unidade\":\"CONSULTORIO ISOLADO\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"RUA BARAO DE SOUZA LEAO\",\"nu_endereco\":\"1080\",\"no_bairro\":\"BOA VIAGEM\",\"co_cep\":\"51030300\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"8134621404\",\"ds_turno_atendimento\":\"ATENDIMENTOS NOS TURNOS DA MANHA E A TARDE\",\"ds_servico_especializado\":\"SERVICO DE DIAGNOSTICO POR IMAGEM\",\"lat\":\"-8.13253\",\"long\":\"-34.90937\",\"origem_coord\":\"CNES_GEO\"},\"distance\":435},{\"data\":{\"co_cnes\":\"5667437\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"\",\"razao_social_mantenedora\":\"\",\"no_razao_social\":\"DANILSON LINS BARBOSA\",\"no_fantasia\":\"DANILSON LINS BARBOSA\",\"ds_tipo_unidade\":\"CONSULTORIO ISOLADO\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"BARAO DE SOUZA LEAO\",\"nu_endereco\":\"1103\",\"no_bairro\":\"BOA VIAGEM\",\"co_cep\":\"51030300\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"8134625759\",\"ds_turno_atendimento\":\"ATENDIMENTO COM TURNOS INTERMITENTES\",\"ds_servico_especializado\":\"\",\"lat\":\"-8.13256\",\"long\":\"-34.90959\",\"origem_coord\":\"CNES_GEO\"},\"distance\":444},{\"data\":{\"co_cnes\":\"3542300\",\"co_ibge\":\"261160\",\"nu_cnpj_mantenedora\":\"\",\"razao_social_mantenedora\":\"\",\"no_razao_social\":\"MANOEL TABOSA LINS GUARANA\",\"no_fantasia\":\"MANOEL TABOSA LINS GUARANA\",\"ds_tipo_unidade\":\"CONSULTORIO ISOLADO\",\"ds_natureza_organizacao\":\"\",\"ds_esfera_administrativa\":\"\",\"tp_gestao\":\"M\",\"no_logradouro\":\"RUA ANTONIO VICENTE\",\"nu_endereco\":\"413\",\"no_bairro\":\"BOA VIAGEM\",\"co_cep\":\"51030480\",\"regiao\":\"Nordeste\",\"uf\":\"PE\",\"municipio\":\"Recife\",\"nu_telefone\":\"(81)34611353\",\"ds_turno_atendimento\":\"ATENDIMENTO SOMENTE A TARDE\",\"ds_servico_especializado\":\"SERVICO DE ATENCAO A SAUDE AUDITIVA\",\"lat\":\"-8.133\",\"long\":\"-34.90849\",\"origem_coord\":\"CNES_GEO\"},\"distance\":478}]";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_maps, container, false);
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        configureMap();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //supportMapFragment = view.findViewById(R.id.maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    void configureMap() {
        List<MarkerOptions> locations = new ArrayList<>();

        try {
            JSONArray all = new JSONArray(LOCATIONS_DUMMY);

            for (int i = 0; i < all.length(); i++) {
                JSONObject data = all.getJSONObject(i).getJSONObject("data");
                LatLng l = new LatLng(Float.parseFloat(data.getString("lat")), Float.parseFloat(data.getString("long")));

                locations.add(new MarkerOptions()
                        .position(l)
                        .title(data.getString("no_fantasia")));
            }

            for (int i = 0; i < locations.size(); i++) {
                System.out.println(locations.get(i));
                mMap.addMarker(locations.get(i));
            }

            CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(locations.get(0).getPosition(), 15);
            mMap.animateCamera(yourLocation);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    JSONArray getLocations(String url)  {
        AsyncHttpClient client = new AsyncHttpClient();

        final JSONArray[] array = {null};
        final boolean[] loop = {true};

        while(loop[0]) {
            client.get(url, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                    array[0] = timeline;
                    loop[0] = false;
                }
            });
        }

        return array[0];
    }
}
