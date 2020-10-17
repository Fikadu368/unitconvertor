package com.example.sillyconvertor;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {



    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView listView= view.findViewById(R.id.listView);

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };


        Product[] products= new Product[values.length];

        for(int i=0; i < values.length;i++){
            products[i]=new Product(values[i],values[i],i);
        }

        ProductRecyclerAdapter productRecyclerAdapter=new ProductRecyclerAdapter(products);
        listView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        listView.setAdapter(productRecyclerAdapter);

        }


   public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder> {
        private Product[] products;
        private Integer[] images;

        public ProductRecyclerAdapter(Product[] myProducts){

            this.products=myProducts;

            this.images= new Integer[]{
                    android.R.drawable.ic_dialog_email,
                    android.R.drawable.ic_btn_speak_now,
                    android.R.drawable.ic_delete,
                    android.R.drawable.ic_dialog_map,
                    android.R.drawable.ic_input_get,
                    android.R.drawable.ic_lock_idle_alarm,
                    android.R.drawable.ic_media_next,
                    android.R.drawable.ic_dialog_email,
                    android.R.drawable.ic_btn_speak_now,
                    android.R.drawable.ic_delete,
                    android.R.drawable.ic_dialog_map,
                    android.R.drawable.ic_input_get,
                    android.R.drawable.ic_media_next,
                    android.R.drawable.alert_dark_frame,
                    android.R.drawable.ic_dialog_email,
                    android.R.drawable.ic_btn_speak_now,
                    android.R.drawable.ic_delete,
                    android.R.drawable.ic_dialog_map,
                    android.R.drawable.ic_input_get,
                    android.R.drawable.ic_media_next,
                    android.R.drawable.ic_media_next,
                    android.R.drawable.ic_dialog_email,
                    android.R.drawable.ic_btn_speak_now,
                    android.R.drawable.ic_delete,
                    android.R.drawable.ic_dialog_map,
                    android.R.drawable.ic_input_get,
                    android.R.drawable.ic_lock_idle_alarm,
                    android.R.drawable.alert_dark_frame,

            };

        }

       @NonNull
       @Override
       public ProductRecyclerAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
            View listItem=layoutInflater.inflate(R.layout.listview_item,parent,false);

            ProductViewHolder viewHolder= new ProductViewHolder(listItem);

           return viewHolder;
       }

       @Override
       public void onBindViewHolder(@NonNull ProductRecyclerAdapter.ProductViewHolder holder, int position) {

            holder.textName.setText(products[position].mName);
            holder.textDescription.setText(products[position].mDescription);
            holder.imageView.setImageResource(this.images[position]);
       }

       @Override
       public int getItemCount() {
           return products.length;
       }

       private class ProductViewHolder extends RecyclerView.ViewHolder{
            public ImageView imageView;
            public TextView  textName;
            public TextView   textDescription;

           public ProductViewHolder(@NonNull View itemView) {
               super(itemView);

               this.imageView=itemView.findViewById(R.id.icon);
               this.textName=itemView.findViewById(R.id.firstLine);
               this.textDescription=itemView.findViewById(R.id.secondLine);
           }
       }


   }

    private class Product{

        private String mName;
        private String mDescription;
        private int mImageId;


        public Product(String name,String desctiption,int imageId){
            this.mName=name;
            this.mDescription=desctiption;
            this.mImageId=imageId;
        }


        public int getmImageId() {
            return mImageId;
        }

        public String getmDescription() {
            return mDescription;
        }

        public String getmName() {
            return mName;
        }

        public void setmDescription(String mDescription) {
            this.mDescription = mDescription;
        }

        public void setmImageId(int mImageId) {
            this.mImageId = mImageId;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }
    }

        }