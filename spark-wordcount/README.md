WordCount Examples for Spark
===============

spark-submit --class  johnnyzhang.bigdata.spark.examples.WordCount --master local[*] wordcount_2.10-0.0.1.jar  /opt/bigdata/spark/README.md /tmp/resScala

spark-submit --master local[*] wordcount.py /opt/bigdata/spark/README.md /tmp/resultpy

spark-submit --class  johnnyzhang.bigdata.spark.examples.WordCount --master local[*] wordcount-java-0.0.1.jar /opt/bigdata/spark/README.md /tmp/resultJava
