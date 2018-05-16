import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.records.reader.impl.transform.TransformProcessRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.transform.TransformProcess;
import org.datavec.api.transform.schema.Schema;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;

public class DeepLearning4j {
    public static void main(String[] args) throws IOException, InterruptedException {
        Schema schema = new Schema.Builder()
                .addColumnsString("RowNumber")
                .addColumnInteger("CustomerId")
                .addColumnString("Surname")
                .addColumnInteger("CreditScore")
                .addColumnCategorical("Geography",Arrays.asList("France","Spain","Germany"))
                .addColumnCategorical("Gender",Arrays.asList("Male","Female"))
                .addColumnsInteger("Age","Tenure","Balance","NumOfProducts","HasCrCard","IsActiveMember","EstimatedSalary","Exited").build();
        TransformProcess transformProcess = new TransformProcess.Builder(schema)
                                                .removeColumns("RowNumber","Surname","CustomerId")
                                                .categoricalToInteger("Gender")
                                                .categoricalToOneHot("Geography").build();
        RecordReader reader = new CSVRecordReader(1,',');
        reader.initialize(new FileSplit(new ClassPathResource("Churn_Modelling.csv").getFile()));
        RecordReader transformProcessRecordReader = new TransformProcessRecordReader(reader,transformProcess);
//        while(transformProcessRecordReader.hasNext()){
//            System.out.println("args = " + transformProcessRecordReader.next() + "");
//        }


        int labelIndex = 13;
        int numClasses = 2;
        int batchSize = 100;
        DataSetIterator iterator = new RecordReaderDataSetIterator(transformProcessRecordReader,labelIndex,numClasses,batchSize);

    }
}
