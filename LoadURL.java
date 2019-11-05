 
 FloatingActionButton fb=(FloatingActionButton)findViewById(R.id.fab);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("market://details?id=com.e_monsite.nazim_app.binazim"));
                if (!MyStartActivity(intent)) {

                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.e_monsite.nazim_app.binazim"));
                    if (!MyStartActivity(intent)) {

                        Toast.makeText(MainActivity.this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    private boolean MyStartActivity(Intent aIntent) {
        try
        {
            startActivity(aIntent);
            return true;
        }
        catch (ActivityNotFoundException e)
        {
            return false;
        }
    }
