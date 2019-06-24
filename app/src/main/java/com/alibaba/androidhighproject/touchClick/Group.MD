### View的传递事件机制
   #### 点击了自定义view  
    
        ```
        2019-06-24 15:59:58.214 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
        2019-06-24 15:59:58.214 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_DOWN
        2019-06-24 15:59:58.216 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了1
        2019-06-24 15:59:58.216 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_DOWN
        2019-06-24 15:59:58.216 30622-30622/com.alibaba.androidhighproject E/SHIT: --onInterceptTouchEvent--:执行了2
        2019-06-24 15:59:58.216 30622-30622/com.alibaba.androidhighproject E/SHIT: --onInterceptTouchEvent--:执行了ACTION_DOWN
        2019-06-24 15:59:58.216 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了1
        2019-06-24 15:59:58.216 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_DOWN
        2019-06-24 15:59:58.217 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity-TouchTextView-onTouchEvent--:执行了ACTION_DOWN
        2019-06-24 15:59:58.217 30622-30622/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了2
        2019-06-24 15:59:58.217 30622-30622/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了ACTION_DOWN
        2019-06-24 15:59:58.228 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
        2019-06-24 15:59:58.228 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_MOVE
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了3
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_MOVE
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: --onInterceptTouchEvent--:执行了4
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: --onInterceptTouchEvent--:执行了ACTION_MOVE
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了3
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_MOVE
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity-TouchTextView-onTouchEvent--:执行了ACTION_MOVE
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了4
        2019-06-24 15:59:58.229 30622-30622/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了ACTION_MOVE
        2019-06-24 15:59:58.251 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
        2019-06-24 15:59:58.251 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_UP
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了5
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_UP
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: --onInterceptTouchEvent--:执行了6
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: --onInterceptTouchEvent--:执行了ACTION_UP
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了5
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_UP
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity-TouchTextView-onTouchEvent--:执行了ACTION_UP
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了6
        2019-06-24 15:59:58.252 30622-30622/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了ACTION_UP
        2019-06-24 15:59:58.255 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--TouchTextView--:执行了
        ```  
   #### 没点击自定义view
    
        ```
       2019-06-24 16:00:31.864 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
       2019-06-24 16:00:31.864 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_DOWN
       2019-06-24 16:00:31.866 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了1
       2019-06-24 16:00:31.866 30622-30622/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_DOWN
       2019-06-24 16:00:31.866 30622-30622/com.alibaba.androidhighproject E/SHIT: --onInterceptTouchEvent--:执行了2
       2019-06-24 16:00:31.866 30622-30622/com.alibaba.androidhighproject E/SHIT: --onInterceptTouchEvent--:执行了ACTION_DOWN
       2019-06-24 16:00:31.866 30622-30622/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了3
       2019-06-24 16:00:31.866 30622-30622/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了ACTION_DOWN
       2019-06-24 16:00:31.867 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--onTouchEvent--:执行了
       2019-06-24 16:00:31.867 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--onTouchEvent--:执行了ACTION_DOWN
       2019-06-24 16:00:31.878 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
       2019-06-24 16:00:31.878 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_MOVE
       2019-06-24 16:00:31.878 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--onTouchEvent--:执行了
       2019-06-24 16:00:31.878 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--onTouchEvent--:执行了ACTION_MOVE
       2019-06-24 16:00:31.945 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
       2019-06-24 16:00:31.945 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_MOVE
       2019-06-24 16:00:31.945 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--onTouchEvent--:执行了
       2019-06-24 16:00:31.945 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--onTouchEvent--:执行了ACTION_MOVE
       2019-06-24 16:00:31.947 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
       2019-06-24 16:00:31.947 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_UP
       2019-06-24 16:00:31.947 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--onTouchEvent--:执行了
       2019-06-24 16:00:31.947 30622-30622/com.alibaba.androidhighproject E/SHIT: Activity--onTouchEvent--:执行了ACTION_UP
        ```
    
总结流程如下：  

  ![image text](https://github.com/xsg2357/AndroidHighProjectDemo/blob/master/app/src/main/java/com/alibaba/androidhighproject/touchClick/groupView1.png)
     
从流程图可以看出：  

   ![image text](https://github.com/xsg2357/AndroidHighProjectDemo/blob/master/app/src/main/java/com/alibaba/androidhighproject/touchClick/groupView2.png)
