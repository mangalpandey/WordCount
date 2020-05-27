import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapperClass extends Mapper<LongWritable, Text, Text,  IntWritable>{
	 @Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String [] ar1 = line.split(" ");
		for(int i = 0;i<ar1.length; i++) {
			String item = ar1[i];
			context.write(new Text(item), new IntWritable(1));
		}
		
 	}
 }