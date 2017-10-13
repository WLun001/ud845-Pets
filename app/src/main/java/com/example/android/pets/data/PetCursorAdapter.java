package com.example.android.pets.data;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.R;

/**
 * Created by Lun on 12/10/2017.
 */

public class PetCursorAdapter extends CursorAdapter {
    private LayoutInflater inflater;

    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return inflater.inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName = (TextView) view.findViewById(R.id.pet_name);
        TextView tvBreed = (TextView) view.findViewById(R.id.pet_breed);

        tvName.setText(cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME)));

        String breed = cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED));
        if (TextUtils.isEmpty(breed)) tvBreed.setText("Unknown breed");
        else tvBreed.setText(breed);
    }
}
