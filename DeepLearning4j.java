import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderMultiDataSetIterator;
import org.nd4j.linalg.dataset.api.MultiDataSet;
import org.nd4j.linalg.dataset.api.iterator.MultiDataSetIterator;
import org.nd4j.linalg.io.ClassPathResource;

import java.io.IOException;

public class DeepLearning4j {

    public static void main(String[] args) throws IOException, InterruptedException {

        RecordReader reader = new CSVRecordReader(1,',');
        reader.initialize(new FileSplit(new ClassPathResource("Churn_Modelling.csv").getFile()));
        MultiDataSetIterator iterator = new RecordReaderMultiDataSetIterator.Builder(100)
                        .addReader("reader",reader)
                        .addInput("reader",3,12)
                        .addOutput("reader",13,13)
                        .addInputOneHot("reader",4,2)
                        .build();


        MultiDataSet dataset = iterator.next();
    }
}
