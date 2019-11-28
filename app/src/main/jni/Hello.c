# include<stdio.h>
# include<stdlib.h>
# include<jni.h>

/*
* jstring 返回值
* Java 全类名：com_alibaba_androidhighproject_jni_study_JNI_
* 方法名：sayHello
* 组成：Java全类名 + 方法名 ，用下划线连接
* jobject jobj ： 谁调用了这个方法的实例
* JNI：就是当前JNI.this
*/
// JNIEXPORT jstring JNICALL
 JNIEXPORT jstring JNICALL
 Java_com_alibaba_androidhighproject_jniStudy_JNI_sayHello(JNIEnv *env,jobject jobj){

   char *text =  'Hello ,I  am  from c';

   return (*env)->NewStringUTF(env,text);
}