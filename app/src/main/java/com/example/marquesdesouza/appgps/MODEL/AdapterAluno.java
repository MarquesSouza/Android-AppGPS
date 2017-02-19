package com.example.marquesdesouza.appgps.MODEL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.example.marquesdesouza.appgps.R;
/**
 * Created by Marques de Souza on 17/02/2017.
 */

public class AdapterAluno extends BaseAdapter {
    private final List<Aluno> alunos;
    private final Activity contexto;
    public AdapterAluno (List<Aluno> alunoList , Activity context){
        this.alunos=alunoList;
        this.contexto=context;
    }
    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= contexto.getLayoutInflater().inflate(R.layout.listviewcustom,parent,false);

        Aluno aluno=alunos.get(position);

        TextView site=(TextView) view.findViewById(R.id.site);
        TextView nome=(TextView) view.findViewById(R.id.nome);
        TextView telefone=(TextView) view.findViewById(R.id.telefone);
        ImageView foto= (ImageView) view.findViewById(R.id.imageView);
        telefone.setText("Telefone: "+aluno.getTelefone());
        nome.setText(aluno.getNome());
        site.setText("Site: "+aluno.getSite());
        if(aluno.getCaminhoFoto().equals("vazio")){
        }else {
            Bitmap bitmap = BitmapFactory.decodeFile(aluno.getCaminhoFoto());
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            foto.setImageBitmap(bitmapReduzido);
            foto.setScaleType(ImageView.ScaleType.FIT_XY);
            foto.setTag(aluno.getCaminhoFoto());
        }
        return view;
    }
}
