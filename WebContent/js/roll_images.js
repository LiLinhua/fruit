	   	//ͼƬÿ���ֻ�
	   	   var ad=document.getElementById("ad");
	   	   var i=0;
	   	   function intervalAds(){
	   	   ad.src="images/roll"+(i+1)+".jpg";
	   	   i=(i+1)%7;//0-3
	   	   }
	   	   
	   	   var time=setInterval(intervalAds,2000);
	   	   //������ͼƬ
	   	   ad.addEventListener("mouseover",function(){
	   	   	   clearInterval(time);
	   	   })
	   	   ad.addEventListener("mouseout",function(){
	   	     	time=setInterval(intervalAds,2000);
	   	   })
			

	   	    
	   	 //��li��click��click��Ӧ��li���ñ���ɫ��ͼƬ���ÿɼ��������li�ޱ���ɫ��ͼƬ�������أ��������ʱ��
	   	 //mouseout�¼�������ʱ��