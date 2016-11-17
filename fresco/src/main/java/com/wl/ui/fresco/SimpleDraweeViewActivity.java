package com.wl.ui.fresco;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.wl.ui.baselib.BaseActivity;

/**
 * Created by wangliang on 16-11-17.
 */

public class SimpleDraweeViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_activity);

        initActionBarWithBack("SimpleFrawee");

        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        SimpleDraweeView circleDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view_circle);
        SimpleDraweeView roundDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view_round);
        SimpleDraweeView gradualDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view_gradual);
        SimpleDraweeView gifDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view_gif);


        initNormalView(draweeView);

        initCircleView(circleDraweeView);

        initRoundView(roundDraweeView);

        initGradualView(gradualDraweeView);

        initGifView(gifDraweeView);
    }

    private void initNormalView(SimpleDraweeView draweeView) {
        Uri uri = Uri.parse("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
        PointF pointF = new PointF();
        pointF.set(1.0f, 1.0f);


        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300) // 设置出现的渐变时间
                .setPlaceholderImage(R.drawable.default_image) //设置默认图
                // 其他请参考文档 https://www.fresco-cn.org/docs/drawee-branches.html#Retry
                .setProgressBarImage(new ProgressBarDrawable()) //设置进度条
                .setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP) //同centerCrop PointF(0.5f, 0.5f)但是中点可以指定
                .setActualImageFocusPoint(pointF)
                .build();
        draweeView.setHierarchy(hierarchy);

        //设置view设置uri
        draweeView.setImageURI(uri);
    }

    private void initCircleView(SimpleDraweeView draweeView) {
        Uri uri = Uri.parse("http://avatar.csdn.net/7/B/3/1_wyb112233.jpg");
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setBorder(R.color.transparent, 0.0f);
        roundingParams.setRoundAsCircle(true);


        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300) // 设置出现的渐变时间
                .setPlaceholderImage(R.drawable.default_image) //设置默认图
                // 其他请参考文档 https://www.fresco-cn.org/docs/drawee-branches.html#Retry
                .setProgressBarImage(new ProgressBarDrawable()) //设置进度条
                .setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP) //同centerCrop PointF(0.5f, 0.5f)但是中点可以指定
                .setRoundingParams(roundingParams)
                .build();
        draweeView.setHierarchy(hierarchy);

        draweeView.setImageURI(uri);
    }

    private void initRoundView(SimpleDraweeView draweeView) {
        Uri uri = Uri.parse("http://avatar.csdn.net/7/B/3/1_wyb112233.jpg");
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(20f);
        roundingParams.setBorder(R.color.transparent, 0.0f);
        roundingParams.setRoundAsCircle(false);


        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300) // 设置出现的渐变时间
                .setPlaceholderImage(R.drawable.default_image) //设置默认图
                // 其他请参考文档 https://www.fresco-cn.org/docs/drawee-branches.html#Retry
                .setProgressBarImage(new ProgressBarDrawable()) //设置进度条
                .setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP) //同centerCrop PointF(0.5f, 0.5f)但是中点可以指定
                .setRoundingParams(roundingParams)
                .build();
        draweeView.setHierarchy(hierarchy);

        draweeView.setImageURI(uri);
    }

    private void initGradualView(SimpleDraweeView draweeView) {
        Uri uri = Uri.parse("http://m2.quanjing.com/2m/alamyrf005/b1fw89.jpg");
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .build();
        draweeView.setController(controller);
    }

    private void initGifView(SimpleDraweeView draweeView) {
//        String imagePath = "http://easyread.ph.126.net/8nXxMl_nIYz5dNXZD_JiNA==/7916985097290849190.gif";
        String imagePath = "http://img.d9soft.com/2015/0725/20150725114852556.gif";
        setControllerListener(draweeView, imagePath, 200 * 3);
    }


    /**
     * 按照宽度自适应
     *
     * @param simpleDraweeView
     * @param imagePath
     * @param imageWidth
     */
    private void setControllerListener(final SimpleDraweeView simpleDraweeView, String imagePath, final int imageWidth) {
        final ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (imageInfo == null) {
                    return;
                }
                QualityInfo qualityInfo = imageInfo.getQualityInfo();
                String str = "Final image received! " +
                        "Size "+imageInfo.getWidth()+" x " +imageInfo.getHeight()+
                        "Quality level "+ qualityInfo.getQuality() +", good enough: "+qualityInfo.isOfGoodEnoughQuality()+ ", full quality: " + qualityInfo.isOfFullQuality();
                Log.d("WLTest", str);
                layoutParams.width = imageWidth;
                layoutParams.height = (int) ((float) (imageWidth * imageInfo.getHeight()) / (float) imageInfo.getWidth());
                simpleDraweeView.setLayoutParams(layoutParams);
            }

            @Override
            public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
                FLog.d("SimpleDraweeViewActivity", "Intermediate image received");
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                FLog.e(getClass(), throwable, "Error loading %s", id);
            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(imagePath))
                .setControllerListener(controllerListener)
                .setAutoPlayAnimations(true)
                .build();
        simpleDraweeView.setController(controller);
    }


}
