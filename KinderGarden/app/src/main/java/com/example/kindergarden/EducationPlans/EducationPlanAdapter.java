package com.example.kindergarden.EducationPlans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kindergarden.R;

import java.util.List;

public class EducationPlanAdapter extends RecyclerView.Adapter<EducationPlanViewHoldel> {

    private Context context;
    private List<EducationPlan> dataList;

    public EducationPlanAdapter(Context context, List<EducationPlan> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public EducationPlanViewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_education_plan, parent,false);
        return new EducationPlanViewHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationPlanViewHoldel holder, int position) {
        holder.resTitile.setText(dataList.get(position).getTitle());
        holder.resDecription.setText(dataList.get(position).getDescription());
        holder.resActivities.setText(dataList.get(position).getActivs());
        holder.resPeriod.setText(dataList.get(position).getDateRange());
        holder.resTeacher.setText(dataList.get(position).getTeacherName());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class EducationPlanViewHoldel extends RecyclerView.ViewHolder{

    TextView resTitile, resDecription, resActivities, resPeriod, resTeacher;
    CardView resCard;

    public EducationPlanViewHoldel(@NonNull View itemView){
        super(itemView);
        resCard = itemView.findViewById(R.id.resCardEdu);
        resTitile = itemView.findViewById(R.id.resTitleEdu);
        resDecription = itemView.findViewById(R.id.resDescEdu);
        resActivities = itemView.findViewById(R.id.resActivitiesEdu);
        resPeriod = itemView.findViewById(R.id.resPeriodEdu);
        resTeacher = itemView.findViewById(R.id.resTeacherEdu);
    }

}