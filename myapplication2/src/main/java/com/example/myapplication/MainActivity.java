package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Produto> listaProdutos;

    private EditText inputProdutoName;
    private EditText inputProdutoValue;
    private EditText inputProdutoQty;

    private Button btnAdd;

    private TextView listProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaProdutos = new ArrayList<Produto>();

        inputProdutoName = findViewById(R.id.inputProductName);
        inputProdutoValue = findViewById(R.id.inputProductValue);
        inputProdutoQty = findViewById(R.id.inputProductQty);
        btnAdd = findViewById(R.id.btnAdd);
        listProducts = findViewById(R.id.listProducts);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto p = new Produto(inputProdutoName.getText().toString(), Double.parseDouble(inputProdutoValue.getText().toString()), Integer.parseInt(inputProdutoQty.getText().toString()));

                listaProdutos.add(p);

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                Toast.makeText(getApplicationContext(),"Produto adicionado com sucesso", Toast.LENGTH_SHORT).show();

                inputProdutoName.setText("");
                inputProdutoValue.setText("");
                inputProdutoQty.setText("");

                inputProdutoName.clearFocus();
                inputProdutoValue.clearFocus();
                inputProdutoQty.clearFocus();

                listProducts.setText("");

                String s = "";
                double valorTotal = 0;
                Produto tempP = null;
                for(int i = 0; i < listaProdutos.size(); i++) {
                    tempP = listaProdutos.get(i);
                    s += tempP.getNome() + " - Valor: $" + tempP.getValorTotal() + "\n";
                    valorTotal += tempP.getValorTotal();
                }

                s += "Valor Total: $" + valorTotal;

                listProducts.setText(s);
            }
        });
    }
}
