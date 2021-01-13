package com.example.fragments;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentListado extends Fragment {

    private Persona[] datos =
            new Persona[]{
                    new Persona("Natalia", "Origen griego. Natalia, como Natalio, toma su raíz de Natal, con la etimología en «natalis dies» (relacionado con el día del natalicio de Cristo), con el significado de día del nacimiento y de aquella que cuida de la vida)"),
                    new Persona("Asperia", "Origen Griego. El Occidente. Los griegos aplicaban este nombre a las penínsulas Itálica e Ibérica"),
                    new Persona("Alicia", "Alicia es un nombre propio femenino de origen griego en su variante en español. Proviene del griego antiguo Αλήθεια (alétheia), que significa verdad. El nombre se popularizó con Las aventuras de Alicia en el país de las maravillas, de Lewis Carroll."),
                    new Persona("Enma", "Emma es un nombre para una niña de origen germánico que significa 'la que es fuerte'. El nombre de vuestra hija se utiliza en todo el mundo sin apenas variantes y se trata de uno de los nombres que más gustan a padres y niñas por la calidez y la ternura que desprende su pronunciación."),
                    new Persona("Ruth", "Ruth es un nombre para niña de origen hebreo que tiene un doble significado de 'amistad' y de 'belleza'")};


    private ListView lstListado;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    private CorreosListener listener;

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        lstListado = (ListView)getView().findViewById(R.id.LstListado);

        lstListado.setAdapter(new AdaptadorCorreos(this));

        lstListado.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
                if (listener!=null) {
                    listener.onListenerNombre(
                            (Persona)lstListado.getAdapter().getItem(pos));
                }
            }
        });
    }
    public interface PersonasListener {

        void onListenerNombre(Persona c);
    }

    public void setCorreosListener(PersonasListener listener) {

        this.listener=listener;
    }

    class AdaptadorCorreos extends ArrayAdapter<Persona> {

        Activity context;

        AdaptadorCorreos(Fragment context) {
            super(context.getActivity(), R.layout.listitem_correo, datos);
            this.context = context.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_correo, null);

            TextView lblDe = (TextView)item.findViewById(R.id.LblDe);
            lblDe.setText(datos[position].getDe());

            TextView lblAsunto = (TextView)item.findViewById(R.id.LblAsunto);
            lblAsunto.setText(datos[position].getAsunto());

            return(item);
        }
    }
}

