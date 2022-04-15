package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import SeperatePackage.aidlInterface;
import SeperatePackage.aidlInterface.Stub;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return stubObject;
    }
    aidlInterface.Stub stubObject=new Stub() {
        @Override
        public int calculateData(int firstValue, int secondValue, int operationToPerform) throws RemoteException {
            return performCalculation(firstValue,secondValue,operationToPerform);
        }
    };


    private int performCalculation(int firstValue,int secondValue,int operationType)
    {
        switch (operationType)
        {
            case 1:
                Log.d("Service_app"," "+Integer.parseInt(String.valueOf(firstValue+secondValue)));
                return firstValue+secondValue;

            case 2:
                return firstValue-secondValue;

            case 3:
                return firstValue*secondValue;

            case 4:
                return firstValue/secondValue;


            default:
                Log.e("Error","Invalid Operation");

        }
        return operationType;
    }

}