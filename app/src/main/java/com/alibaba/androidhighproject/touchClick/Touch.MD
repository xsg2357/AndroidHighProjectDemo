#### View的传递事件机制
    ```
    2019-06-24 15:19:12.544 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
    2019-06-24 15:19:12.545 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_DOWN
    2019-06-24 15:19:12.546 21640-21640/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了1
    2019-06-24 15:19:12.546 21640-21640/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_DOWN
    2019-06-24 15:19:12.547 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity-TouchTextView-onTouchEvent--:执行了ACTION_DOWN
    2019-06-24 15:19:12.547 21640-21640/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了2
    2019-06-24 15:19:12.548 21640-21640/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了ACTION_DOWN
    2019-06-24 15:19:12.560 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
    2019-06-24 15:19:12.560 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_MOVE
    2019-06-24 15:19:12.561 21640-21640/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了3
    2019-06-24 15:19:12.561 21640-21640/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_MOVE
    2019-06-24 15:19:12.561 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity-TouchTextView-onTouchEvent--:执行了ACTION_MOVE
    2019-06-24 15:19:12.561 21640-21640/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了4
    2019-06-24 15:19:12.561 21640-21640/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了ACTION_MOVE
    2019-06-24 15:19:12.606 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了
    2019-06-24 15:19:12.606 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity--dispatchTouchEvent--:执行了ACTION_UP
    2019-06-24 15:19:12.607 21640-21640/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了5
    2019-06-24 15:19:12.607 21640-21640/com.alibaba.androidhighproject E/SHIT: --dispatchTouchEvent--:执行了ACTION_UP
    2019-06-24 15:19:12.607 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity-TouchTextView-onTouchEvent--:执行了ACTION_UP
    2019-06-24 15:19:12.607 21640-21640/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了6
    2019-06-24 15:19:12.607 21640-21640/com.alibaba.androidhighproject E/SHIT: --onTouchEvent--:执行了ACTION_UP
    2019-06-24 15:19:12.610 21640-21640/com.alibaba.androidhighproject E/SHIT: Activity--TouchTextView--:执行了
    ```  
    
总结流程如下：  

  ![image text](https://github.com/xsg2357/AndroidHighProjectDemo/blob/master/app/src/main/java/com/alibaba/androidhighproject/touchClick/view1.png)
     
从流程图可以看出：  

   ![image text](https://github.com/xsg2357/AndroidHighProjectDemo/blob/master/app/src/main/java/com/alibaba/androidhighproject/touchClick/view2.png)
