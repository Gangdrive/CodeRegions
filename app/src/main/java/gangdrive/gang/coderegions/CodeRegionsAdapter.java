package gangdrive.gang.coderegions;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CodeRegionsAdapter extends RecyclerView.Adapter<CodeRegionsAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private List<CodeRegions> codeRegionsList;

    public void setFilteredList(List<CodeRegions> filteredList){
        this.codeRegionsList= filteredList;
        notifyDataSetChanged();
    }

    public CodeRegionsAdapter(Context context, List<CodeRegions> codeRegions) {
        this.inflater = LayoutInflater.from(context);
        this.codeRegionsList = codeRegions;
    }

    @NonNull
    @Override
    public CodeRegionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_code_region_show, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CodeRegionsAdapter.ViewHolder holder, int position) {
        CodeRegions codeRegions = codeRegionsList.get(position);
        holder.tvCodeRegion.setText(codeRegions.getCode());
        holder.tvNameRegion.setText(codeRegions.getRegions());

    }

    @Override
    public int getItemCount() {
        return codeRegionsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvCodeRegion;
        final TextView tvNameRegion;

        ViewHolder(View view) {
            super(view);
            tvCodeRegion = view.findViewById(R.id.tvCodeRegion);
            tvNameRegion = view.findViewById(R.id.tvNameRegion);


        }
    }
}
