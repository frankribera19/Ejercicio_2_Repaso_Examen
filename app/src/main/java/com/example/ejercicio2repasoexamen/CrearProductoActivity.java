package com.example.ejercicio2repasoexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.ejercicio2repasoexamen.databinding.ActivityCrearProductoBinding;
import com.example.ejercicio2repasoexamen.modelos.Producto;

public class CrearProductoActivity extends AppCompatActivity {

    private ActivityCrearProductoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);

        binding = ActivityCrearProductoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCancelarCrearProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        binding.btnCrearCrearProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto();

                if ((producto = crearProducto()) != null){
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("PRODUCTO",producto);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    private Producto crearProducto() {
        Producto producto;
        if (binding.txtNombreCrearProducto.getText().toString().isEmpty() &&
            binding.txtCantidadCrearProducto.getText().toString().isEmpty() &&
            binding.txtPrecioCrearProducto.getText().toString().isEmpty()){
            Toast.makeText(this, "tienes que rellenar los datos", Toast.LENGTH_SHORT).show();
            return null;
        }else{
            String n;
            int c;
            float p;

            n = binding.txtNombreCrearProducto.getText().toString();
            c = Integer.parseInt(binding.txtCantidadCrearProducto.getText().toString());
            p = Float.parseFloat(binding.txtPrecioCrearProducto.getText().toString());

            

            producto = new Producto(n,p,c);
            return producto;
        }

    }
}