package edu.qc.seclass.glm.viewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class EditQuantityVMFactory implements ViewModelProvider.Factory {
        private Application mApplication;
        private int listId;


        public EditQuantityVMFactory(Application application, int listId) {
            mApplication = application;
            this.listId = listId;
        }


        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new EditQuantityVM(mApplication, listId);
        }
}
