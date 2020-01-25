public class myRecycleViewAdapter extends RecyclerView.Adapter<myRecycleViewAdapter.ViewHolder> {


    private String[] names;
    private int[] drawables;
    private Context context;

    public myRecycleViewAdapter(Context cont,String[] strings,int[] resources ){

        this.names=strings;
        this.context=cont;
        this.drawables=resources;

    }
    @NonNull
    @Override
    public myRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.textView.setText(names[i]);
        viewHolder.img.setImageResource(drawables[i]);
        /*
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GSM.dualCall( context,)
                Log.d("Nazim","click");
            }
        });*/
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainPanel) v.getContext()).onClickCalled("offre "+i+" "+names[i]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drawables.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.item_img_id);
            textView=itemView.findViewById(R.id.item_text_id);
        }
    }
}
