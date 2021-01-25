package com.example.proyectobdandroidv3;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class UsuarioBD {
   /* private final static int calculateIndex(){
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Usuario.class).max("id");
        int nextId;
        if(currentIdNum == null){
            nextId = 0;
        }else {
            nextId = currentIdNum.intValue()+1;
        }
        return nextId;
    }*/

    public final static void addUsuario(final Usuario usuario) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Usuario realmUsuario = realm.createObject(Usuario.class, MyApp.UsuarioID.incrementAndGet());
                realmUsuario.setNombre(usuario.getNombre());
                realmUsuario.setEdad(usuario.getEdad());
                realmUsuario.setDescripcion(usuario.getDescripcion());

                realm.copyToRealm(realmUsuario);
            }
        });
    }

    public final static void delUsuario(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Usuario usuario = realm.where(Usuario.class).equalTo("id", id).findFirst();
                usuario.deleteFromRealm();
            }
        });
    }

    public final static List<Usuario> getAllUsuario(TextView textView) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Usuario> usuarios = realm.where(Usuario.class).findAll();
        for (Usuario usuario : usuarios) {
            textView.setText(usuarios.toString());
            //textView.setText("ID: " + usuario.getId() + "; Nombre: " + usuario.getNombre() + "; Edad: " + usuario.getEdad() + "; Descripción: " + usuario.getDescripcion());
            //Log.d("TAG", "id: " + usuario.getId() + " Nombre: " + usuario.getNombre() + " Edad: " + usuario.getEdad() + " Descripción: " + usuario.getDescripcion());
        }
        return usuarios;
    }

    public final static Usuario getUsuarioByName(String name, TextView textView) {
        Realm realm = Realm.getDefaultInstance();
        Usuario usuario = realm.where(Usuario.class).equalTo("nombre", name).findFirst();
        if (usuario != null) {
            textView.setText("ID: " + usuario.getId() + "; Nombre: " + usuario.getNombre() + "; Edad: " + usuario.getEdad() + "; Descripción: " + usuario.getDescripcion());
            //Log.d("TAG", "id: " + usuario.getId() + " Nombre: " + usuario.getNombre() + " Edad: " + usuario.getEdad() + " Descripción: " + usuario.getDescripcion());
        }
        return usuario;
    }

    public final static Usuario getUsuarioById(int id, TextView textView) {
        Realm realm = Realm.getDefaultInstance();
        Usuario usuario = realm.where(Usuario.class).equalTo("id", id).findFirst();
        if (usuario != null) {
            textView.setText("ID: " + usuario.getId() + "; Nombre: " + usuario.getNombre() + "; Edad: " + usuario.getEdad() + "; Descripción: " + usuario.getDescripcion());
            //Log.d("TAG", "id: " + usuario.getId() + " Nombre: " + usuario.getNombre() + " Edad: " + usuario.getEdad() + " Descripción: " + usuario.getDescripcion());
        }
        return usuario;
    }
}