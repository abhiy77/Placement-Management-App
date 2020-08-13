package com.hiring.placementmanagement;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hiring.placementmanagement.com.hiring.placementmanagement.model.Company;

import java.net.URL;
import java.util.ArrayList;

public class EligibleCompanyAdapter extends ArrayAdapter<Company> {

    public EligibleCompanyAdapter(Context context, ArrayList<Company> eligibleCompanies) {
        super(context, 0, eligibleCompanies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Company company = getItem(position);

        if (convertView == null) {
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.eligible_company_list_view,parent,false);
        }
        ImageView companyImage = convertView.findViewById(R.id.image);
        TextView companyName = convertView.findViewById(R.id.company_name);// only all textview need to be added
        TextView companyPackage= convertView.findViewById(R.id.company_package);
        TextView cgpa= convertView.findViewById(R.id.cgpa);
        TextView description= convertView.findViewById(R.id.description);
        TextView contact= convertView.findViewById(R.id.contact);

        assert company != null;
        companyName.setText(company.getCompanyName());
        companyPackage.setText(company.getCompanyPackage());
        cgpa.setText(company.getCGPA());


        URL url;
        try {
            url = new URL(company.getCompanyImage());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            companyImage.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        description.setText(company.getDescription());
        contact.setText(company.getContactNumber());

        return convertView;
    }
}
