import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriverClass{
	public static void main(String []args) throws Exception{
		if(args.length != 2) {
			System.out.print("Usege: WordCount <input dir> <output dir>\n");
			System.exit(-1);
		}else {
			System.out.print("Usege: WordCount");
		}
		@SuppressWarnings("deprecation")
		Job job = new Job();
		job.setJobName("Word Count");
		job.setMapperClass(MyMapperClass.class);
		job.setReducerClass(WordReducerClass.class);
		job.setJarByClass(MyDriverClass.class);
		job.setCombinerClass(WordReducerClass.class);
		job.setNumReduceTasks(0);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		 boolean success = job.waitForCompletion(true);
		    System.exit(success ? 0 : 1);
	}
}

