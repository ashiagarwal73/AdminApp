package com.agarwal.ashi.adminapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    CheckBox checkBox;
    Button button;
    String email;
    String fullname;
    String transaction;
    FirebaseSend firebaseSend;
    final FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mDatabase= firebaseDatabase.getReference().child("Register_details");
    //private DatabaseReference mDatabase2= FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edittext);
        checkBox=findViewById(R.id.checkbox);
        button=findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBox.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Check the box", Toast.LENGTH_SHORT).show();
                }
                 if(editText.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter valid transaction id ", Toast.LENGTH_SHORT).show();
                }
                else {
                     final Query query = mDatabase.orderByChild("transaction").equalTo(editText.getText().toString());
                     query.addListenerForSingleValueEvent(new ValueEventListener() {
                         @Override
                         public void onDataChange(DataSnapshot dataSnapshot) {
                             if (dataSnapshot.exists()) {
                                 //here means the value exist
                                 //do whatever you want to do
                                 for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                                     firebaseSend=userSnapshot.getValue(FirebaseSend.class);
                                     email=firebaseSend.getEmail();
                                     fullname=firebaseSend.getFullname();
                                     transaction=firebaseSend.getTransaction();
                                     firebaseSend.setSend("sent");
                                     mDatabase.child(firebaseSend.transaction).setValue(firebaseSend);
                                     Sending_data sending_data=new Sending_data(MainActivity.this,"false");
                                     sending_data.execute("http://upesacm.org/ACM_App/payment_confirmation.php?transaction="+editText.getText().toString()+"&email="+email.replaceAll(" ","+")+"&name1="+fullname.replaceAll(" ","+")+"&sendmail=sent");
                                     editText.setHint("Enter new Transaction Id");
                                     editText.setText("");
                                     checkBox.setChecked(false);
                                     Toast.makeText(MainActivity.this, "Submitted", Toast.LENGTH_SHORT).show();

                                 }} else {
                                 //here means the value not exist
                                 //do whatever you want to do
                                 Toast.makeText(MainActivity.this,"not exist", Toast.LENGTH_SHORT).show();
                             }
                         }

                         @Override
                         public void onCancelled(DatabaseError databaseError) {

                         }
                     });
                 }
            }
        });
    }
}
