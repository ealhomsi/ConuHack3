package ibm;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class IBM {
    public static void main(String[] args) {
        VisualRecognition service = new VisualRecognition(
                VisualRecognition.VERSION_DATE_2016_05_20
        );
        service.setApiKey("7818f2e5f1bf15336fbdda1bcd220d332e80deab");

        // Read input from user
        String fileName = System.getProperty("image");

        InputStream imagesStream = null;
        try {
            imagesStream = new FileInputStream(fileName);
            ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
                    .imagesFile(imagesStream)
                    .imagesFilename(fileName)
                    .parameters(
                            "{ \"classifier_ids\": [\"default\"], \"threshold\": 0.6}")
                    .build();
            ClassifiedImages result = service.classify(classifyOptions).execute();
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
