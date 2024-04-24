<%@taglib uri="http://www.sangmeng.simpleTag.com" prefix="sms"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
  <title>安徽科技学院医疗医疗挂号系统</title>
  <!-- Bootstrap -->
  <link rel="stylesheet" href="css/commons.css"/>
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
  <style>
    p{
        font: 18px/20px "fangsong";
    }
  </style>
</head>
<body>
  <div id="header" class="container">
      <div class="container first-c">
        <div class="index-list">
          <ul id="first-ul">
           
            <sms:login></sms:login>
          </ul>
        </div>
        <div>
          <div>
            <img src="img/icon_logo_new.png"/>
          </div>
        </div>
      </div>
    <nav class="navbar navbar-default mynav">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li ><a href="index.jsp">首页 </a></li>
            <li><a href="administrativeInformation.jsp">挂号服务</a></li>
            <li><a href="AppointmentServlet">预约管理</a></li>
            <li><a href="InvestServlet">充值管理</a></li>
            <li><a href="conduct.jsp">预约指南</a></li>
            <li class="active"><a href="#">通知反馈<span class="sr-only">(current)</span></a></li>
          </ul>
          <form class="navbar-form navbar-left mysearch">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
          </form>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
  </div>
  <div class="container"><h5 class="page-header"></h5></div>
  <div id="center" class="container">
    <h1 class="text-center">回首之间</h1>
    <div class="text-justify" style="text-indent: 2em">
      <p>一片开阔、富饶的平原上，突然浓烟滚滚，那片平原上的一座城，被翻卷呼啸的火焰所吞噬，从远处望去，就像升腾着烟气的窑。城里的哭嚎声，哀叫声，和烈焰一起沸腾，但这声音传到旷野上，又是那么的细弱，比旷野上轻轻飘荡的风丝还细，细得几乎无法听到，呈现在人们眼前的只有浓烟和烈焰。</p>

      <p>有四个人从那座城里逃出来，他们是这场灾难的唯一逃脱者——一个男人和三个女人。这是以骨肉和血缘连结的一个残缺的家庭：男人与妻子，还有他们的两个女儿。</p>

      <p>他们是往旷野另一处的一个名叫琐耳的小城奔逃，到了那里，他们就可免于灾难。那座小城，就在他们的眼前，小城是那样的安宁，那样的静谧，就像波涛汹涌的大海边的一个港湾。他们只要再跑一程，再跑一小段路，只要再坚持一下，再坚持一小会儿，他们就被幸运所怀抱，然而就在这时候，男人的妻子忍不住回过头来向那城的方向望了一下，那座城里还有她的女儿女婿，有他们用双手建立起来给他们带来温馨和幸福的家……就在她回头的那一瞬，她变成了一个盐柱。</p>

      <p> 数日后，浓烟散去，那座城成为旷野的一部分。旷野上，草木萧萧，寒风瑟瑟，一个洁白的盐柱亭亭而立，在微风中挺着秀丽，在日光中闪着晶莹，人们分不清这是苍天下的一个醒目的叹号，还是旷野上的一个美丽的风景。</p>

      <p>这是圣经里的一段故事，记述的是上帝因所多玛人罪孽过重而毁灭这座城，在毁灭之前救义人罗得一家人逃离这座城，并嘱咐他们不可回头，罗得的妻子因为顾恋这座城而回头瞻望，立即变成了盐柱……</p>

      <p>在人生的道路上我们何尝不也这样奔跑着，向着某一个方向，朝着某一个目标。与其说我们努力前面的，不如说我们更害怕后面的。前面的召唤朦胧而模糊，在后面等待我们的却真实而严酷：那是冷眼，是唾沫， 是讥笑，是嘲讽，是物质的匮乏，是自由的缺失，是价值的贬抑，是尊严的践踏，那是魔鬼的鞭子。魔鬼的皮鞭，抽打着每一个落在后面的人。</p>

      <p>自从诞生那日起，我们就面对着一道岸，那是人生的彼岸，那里耸立着属于每一人的人生的灯塔和丰碑。我们或是朝那个方向极目而望，或是朝着那个方向走了很长一段路，但我们都没有最终到达那里(只有少数人除外)，我们都在某个时刻某个节点在某个安稳的地方站住了——只因我们有太多的回首，只因我们有太多的顾盼，于是我们成了盐柱。尽管这些盐柱形状各异：有高大的，有低矮的，有秀美的，有丑陋的，有明亮的，有暗淡的，但都是生命的凝固与冻结。</p>

      <p>我们每一个人都自觉或不自觉的遵从着这种“盐柱效应”。我并不是说每一人都是人生的失败者，我是说我们中很多人，或者说大多数人都面临着来自人性弱点的咒语：我们过早地使我们的生命成为一种结晶。</p>

      <p>“就差一步，如果我再前进一点点，或许我就有一个新的人生”。</p>

      <p>“如果我能坚持一下，我就不是现在的我”。</p>

      <p>“人生有许多十字路口，我在那个十字路口上迷惘了”。</p>

      <p>“人生有太多的无奈，在太多的无奈中我低头……</p>

      <p> 当最后在检点自己的人生时，每一个人都带着这样的或那样的一串遗憾与叹息，这些遗憾和叹息有一个共同的指向：人生的失落。我们总是止步于最后一里路，我们总是有一步之差，我们总是功亏一篑。这最后一里路，这一步之差，这最后一篑，却成了许多人的人生巨壑。我们之所以迈不过这道人生之壑，是因为我们缺少了生命中最重要的一种东西，这种东西就是：信念。</p>

      <p>信念是生命的最初应许，信念是人生的最终承诺，信念是初衷，信念是坚守，信念是高高架起的心灵之路，信念是通向彼岸的桥梁，信念是不因障碍与阻隔而改变的方向，信念是跨越里程与距离的丰碑。</p>

      <p>那个应许，那个承诺，那个初衷，那个坚守，那条路，那个桥，那个方向，那个碑，不是在别的地方，就在你的生命中，就在你的心里，不要说你没有看见它，是你在某一时候将它迷失了，而这一切，就发生在你的某个回首之间。</p>
    </div>
    <div class="text-right col-sm-11" id="Time">time</div>
  </div>
  <div id="rear" class="container">
    <div>
      <p><h2>安徽省统一预约挂号系统</h2></p>
    </div>
    <div>
      <span>地址：安徽省蚌埠市安徽科技学院&nbsp;&nbsp;&nbsp;&nbsp;技术支持：安徽科技学院图灵网络中心</span>
    </div>
    <div>
      <span>皖ICP备12059770号 <img src="img/beian.png"/> 皖公网安备 44010402000394号  <img src="img/pic1.gif"></span>
    </div>
  </div>
  <script src="js/jquery-1.11.1.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script>
    $(function(){
      window.setInterval(function () {
          $("#Time").text(new Date());
      });
    });
  </script>
  </body>
</html>