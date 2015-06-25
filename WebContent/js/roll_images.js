	   	//图片每秒轮换
	   	   var ad=document.getElementById("ad");
	   	   var i=0;
	   	   function intervalAds(){
	   	   ad.src="images/roll"+(i+1)+".jpg";
	   	   i=(i+1)%7;//0-3
	   	   }
	   	   
	   	   var time=setInterval(intervalAds,2000);
	   	   //鼠标进入图片
	   	   ad.addEventListener("mouseover",function(){
	   	   	   clearInterval(time);
	   	   })
	   	   ad.addEventListener("mouseout",function(){
	   	     	time=setInterval(intervalAds,2000);
	   	   })
			

	   	    
	   	 //对li绑定click，click对应的li设置背景色和图片设置可见，其余的li无背景色，图片设置隐藏，并且清空时钟
	   	 //mouseout事件，启动时钟