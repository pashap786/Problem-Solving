import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.transform.TransformProcess;
import org.datavec.api.transform.schema.Schema;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerStandardize;
import org.nd4j.linalg.io.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeepLearning4j {

    private static Logger log = LoggerFactory.getLogger("DeepLearning4j.class");

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
        System.out.println("args = " + transformProcessRecordReader.next() + "");

        int labelIndex = 12;
        int numClasses = 1;
        int batchSize = 100;

        DataSetIterator iterator = new RecordReaderDataSetIterator(transformProcessRecordReader,batchSize,labelIndex,numClasses);
        List<DataSet> dataList = new ArrayList<>();

        while(iterator.hasNext()){
             dataList.add(((RecordReaderDataSetIterator) iterator).next());
        }

        DataSet allData = DataSet.merge(dataList);
        SplitTestAndTrain testAndTrain = allData.splitTestAndTrain(0.80);

        DataSet trainSet = testAndTrain.getTrain();
        DataSet testSet = testAndTrain.getTest();

        DataNormalization dataNormalization = new NormalizerStandardize();
        dataNormalization.fit(trainSet);
        dataNormalization.transform(trainSet);
        dataNormalization.transform(testSet);

        log.info("Building Model------------------->>>>>>>>>");


    }
}
