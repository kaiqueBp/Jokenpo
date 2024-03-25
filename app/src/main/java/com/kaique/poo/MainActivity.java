package com.kaique.poo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Animal animal = new Animal();
        animal.setCor("pardo");
        Cachorro cachorro = new Cachorro();

    }

    public void selecionadoPedra(View view) {
        this.itemSelecionado("pedra");
    }

    public void selecionadoPapel(View view) {
        this.itemSelecionado("papel");
    }

    public void selecionadoTesoura(View view) {
        this.itemSelecionado("tesoura");
    }

    public void itemSelecionado(String item) {
        ImageView imagem = findViewById(R.id.idimagem);
        TextView resultado = findViewById(R.id.idText);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoSelecionada = opcoes[numero];
        switch (opcaoSelecionada) {
            case "pedra":
                imagem.setImageResource(R.drawable.pedra);
                imagem.setBackgroundResource(R.drawable.padrao);
                break;
            case "papel":
                imagem.setImageResource(R.drawable.papel);
                imagem.setBackgroundResource(R.drawable.padrao);
                break;
            case "tesoura":
                imagem.setImageResource(R.drawable.tesoura);
                imagem.setBackgroundResource(R.drawable.padrao);
                break;
        }
        if (item == "pedra" && opcaoSelecionada =="papel" || item == "papel" && opcaoSelecionada =="tesoura" || item == "tesoura" && opcaoSelecionada =="pedra") {
            resultado.setText("Você perdeu :(");
        } else if (item == "pedra" && opcaoSelecionada =="tesoura" || item =="tesoura" && opcaoSelecionada=="papel" || item=="papel" && opcaoSelecionada=="pedra") {
            resultado.setText("Você ganhou :)");
        }else {
            resultado.setText("Empatamo:/");
        }
    }
}