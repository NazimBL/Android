public class SecondTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i("Nazim","Second Task started");

    }

    @Override
    protected Void doInBackground(Void... voids) {

        for(int i=0;i<20;i++) {
            try {
                Log.i("Nazim", "Secondt Task" + i);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("Nazim","Second Task finished");
    }
}
