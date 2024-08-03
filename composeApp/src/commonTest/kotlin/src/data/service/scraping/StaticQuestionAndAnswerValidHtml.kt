package src.data.service.scraping

// https://darulifta-deoband.com/home/en/taharah-purity/55998
val staticQuestionAndAnswerValidHtml = """
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <title>Plastic tank and dead animal</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Plastic tank and dead animal">
    <meta name="keyword" content="Plastic tank and dead animal">
    <link href="https://darulifta-deoband.com/siteassets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="https://darulifta-deoband.com/siteassets/css/style.css" rel="stylesheet" type="text/css" />
    <link href="https://darulifta-deoband.com/siteassets/css/grey.css" rel="stylesheet" type="text/css" />
    <link href="https://darulifta-deoband.com/siteassets/css/pagination.css" rel="stylesheet" type="text/css" /> <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
    <script async src="https://darulifta-deoband.com/siteassets/js/script.js" type="af4e0e11a4546cdbc357526b-text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="af4e0e11a4546cdbc357526b-text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js" type="af4e0e11a4546cdbc357526b-text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" type="af4e0e11a4546cdbc357526b-text/javascript"></script>
    <script src="https://use.fontawesome.com/releases/v5.13.1/js/all.js" data-auto-replace-svg="nest" type="af4e0e11a4546cdbc357526b-text/javascript"></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer type="af4e0e11a4546cdbc357526b-text/javascript"></script>
    </head>
    <body>
    <header class="latest_main_header">
    <div class="top_bar">
    <div class="container">
    <div class="row">

    <div class="col-md-6 text-left">

    <div style="margin:15px;font-size:1.2em">
    <a href="https://darululoom-deoband.com" style="color:#000">Darul Uloom Deoband, India</a>
    </div>
    </div>
    <div class="col-md-6 text-right">
    <div class="_overflow--visible is-flex _flex--self--center _h--100" style="line-height:2.2;">

    <a href="/en" class="language-toggle language-toggle--upper-header" style="background: #7a9d96;margin-right: 10px;">
    <span class="lang-text" style="background: #7a9d96;color: #fff;">English</span>
    </a>
    <a href="/ur" class="language-toggle language-toggle--upper-header" style="margin-right: 10px;">
    <span class="lang-text" style="color: #000;font-size: 1.8em;">اردو</span>
    </a>

    <div class="user-account user-account--upper-header">
    <a href="https://darulifta-deoband.com/en/login">
    <nav class="login_signup_text">
    <span class="login-text">Login/Signup</span>
    <span class="icon _ml--3 fa-account-text"><i class="fa fa-user-circle-o fa-2x"></i></span>
    </nav>
    </a>
    </div>
    </div>
    </div>

    </div>
    </div>
    </div>
    <div class="header__language-bar" style="display:none;">
    <div class="container">
    <div class="row">
    <div class="col-md-12">
    <ul class="language_option">
    <li><a href="https://darulifta-deoband.com/en" class="navbar-item is-tab has-text-centered">English</a></li>
    <li><a href="https://darulifta-deoband.com/ur" class="navbar-item is-tab has-text-centered">اردو</a></li>

    </ul>
    </div>
    </div>
    </div>
    </div>
    <div class="middle_header">
    <div class="container">
    <div class="row">
    <div class="col-md-5">
    <a href="https://darulifta-deoband.com/en" class="header_logo">
    <img src="/assets/images/logo-en.png" alt="Darul Ifta - Darul Uloom Deoband India" width="80%" />
    </a>
    </div>
    <div class="col-md-7">
    <div class="header_srch enhi">
    <script async src="https://cse.google.com/cse.js?cx=010118156426887088994:komd2vmfyig" type="af4e0e11a4546cdbc357526b-text/javascript"></script>
    <div class="gcse-search"></div>
    </div>

    </div>
    </div>
    </div>
    </div>
    <div class="bottom_header">
    <div class="container">
    <div id="navMenu" class="navbar-menu header__menu__navbar-menu">
    <ul class="header_menu">
    <li>
    <a class="navbar-item" href="https://darulifta-deoband.com/en"><span class="icon _mr--3"><i class="fa fa-home"></i></span> </a>
    </li>
    <li class="menu_items_mega">
    <a class="navbar-item" href="javascript:;">Categories <span class="icon _mr--3" style="padding-top: 4px;"><i class="fa fa-caret-down"></i></span></a>
    <ul class="mega_sub_menu">
    <h5 class="total_res_ques">Total Questions: 9181</h5>
    <li>
    <div class="container">
    <div class="row">
    <div class="cat_part_sec">
    <h3>Faiths & Beliefs</h3>
    <ul class="sub_level_menu">
    <li><a href="https://darulifta-deoband.com/home/qa/islamic-beliefs/1">Islamic Beliefs ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/world-religions/2">World Religions ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/false-sects/3">False Sects ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/deviant-sects/4">Deviant Sects ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/innovations-customs/5">Innovations & Customs ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/taqleed-fighi-schools/6">Taqleed & Fighi Schools ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/the-holy-quran/7">The Holy Quran ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/hadith-sunnah/8">Hadith & Sunnah ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/dawah-tableeg/9">Dawah & Tableeg ()</a></li>
    </ul>
    </div>
    <div class="cat_part_sec">
    <h3>Miscellaneous</h3>
    <ul class="sub_level_menu">
    <li><a href="https://darulifta-deoband.com/home/qa/halal-haram/10">Halal & Haram ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/dua-supplications/11">Dua (Supplications) ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/islamic-names/13">Islamic Names ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/tasawwuf/14">Tasawwuf ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/history-biography/15">History & Biography ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/international-relations/16">International Relations ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/others/17">Others ()</a></li>
    </ul>
    </div>
    <div class="cat_part_sec">
    <h3>Prayers & Duties</h3>
    <ul class="sub_level_menu">
    <li><a href="https://darulifta-deoband.com/home/qa/taharah-purity/18">Taharah (Purity) ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/salah-prayer/19">Salah (Prayer) ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/jumuah-eid-prayers/20">Jumuah & Eid Prayers ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/death-funeral/21">Death & Funeral ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/sawm-fasting/22">Sawm (Fasting) ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/zakat-charity/23">Zakat & Charity ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/hajj-umrah/24">Hajj & Umrah ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/oaths-vows/25">Oaths & Vows ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/waqf-mosque-madrasa/26">Waqf, Mosque, Madrasa ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/qurbani-slaughtering/27">Qurbani (Slaughtering) ()</a></li>
    </ul>
    </div>
    <div class="cat_part_sec">
    <h3>Social Matters</h3>
    <ul class="sub_level_menu">
    <li><a href="https://darulifta-deoband.com/home/qa/nikah-marriage/28">Nikah (Marriage) ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/talaq-divorce/29">Talaq (Divorce) ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/food-drinks/30">Food & Drinks ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/clothing-lifestyle/31">Clothing & Lifestyle ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/rights-etiquettes/32">Rights & Etiquettes ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/education-upbringing/33">Education & Upbringing ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/women-s-issues/34">Women's Issues ()</a></li>
    </ul>
    </div>
    <div class="cat_part_sec">
    <h3>Transactions & Dealings</h3>
    <ul class="sub_level_menu">
    <li><a href="https://darulifta-deoband.com/home/qa/business/35">Business ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/shares-investments/36">Shares & Investments ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/interest-insurance/37">Interest & Insurance ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/other-transactions/38">Other Transactions ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/inheritance-will/39">Inheritance & Will ()</a></li>
    <li><a href="https://darulifta-deoband.com/home/qa/penal-code/40">Penal Code ()</a></li>
    </ul>
    </div>
    </div>
    </div>
    </li>
    </ul>
    </li>
    <li><a class="navbar-item" href="https://darulifta-deoband.com/en/about">About</a></li>
    <li><a class="navbar-item" href="https://darulifta-deoband.com/en/askquestion">Ask Question</a></li>
    <li><a class="navbar-item" href="https://darulifta-deoband.com/en/contact">Contact</a></li>
    </ul>
    </div>
    </div>
    </div>
    </header>
    <div id="midle_content">
    <div class="container">
    <div class="col-md-12">
    <div class="tab-content">
    <div id="recent_fatwas" class="container tab-pane active"><br>
    <ul class="answer_detail">
    <li>
    <div class="cate_sec">
    <p class="category_name">
    <span>
    Prayers & Duties </span>
    >>
    <span>
    <a href="https://darulifta-deoband.com/home/qa/taharah-purity/18">Taharah (Purity)</a>
    </span>
    </p>
    <p class="quesid"><span class="ques_id">Question ID: 55998</span><span class="country_id">Country: India</span></p>
    </div>
    <h2><u>Title: </u> Plastic tank and dead animal</h2>
    <h2><u>Question: </u> I would like to ask that if there is a dead animal like mouse or any other animal in the water tank made of plastic do we have to replace the tank or it can be purified only by washing? And can this tank be used after washing? Is the water pure because I heard somewhere that islamically plastic cannot be purified? </h2>
    <p class="fatwa_answer"><span class="ans_id">Answer ID: 55998</span><span style="color:#efefef; display:none;" class="ans_date">Posted on:
    Aug 30, 2020</span></p>
    <p>Bismillah hir-Rahman nir-Rahim !</p>
    <p> (Fatwa: 1317/1039/D=12/1435)
    The things which do not absorb water such as the utensil of plastic etc shall be pure after washing three times. Thus you may use the said water tank after washing and the waster filled in it shall be pure. There is no need to replace the water tank.</p>
    <div class="mt-4">
    <p><b>Allah (Subhana Wa Ta'ala) knows Best</b></p>
    <p>Darul Ifta, </p>
    <p>Darul Uloom Deoband, India</p>
    </div>
    </li>
    </ul>
    </div>
    </div>
    <div id="Question_list_related">
    <div class="container">
    <div class="row">
    <div class="inner_container_list">
    <div id="recent_fatwas" class="container tab-pane active">
    <div class="heading_related_ques">
    <h1 class="related_questions">Related Questions</h1>
    </div>
    <div class="ques_list_items">
    <ul class="questions_list">
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/61984"><span>Q.</span> Residue found on body hours after intercourse. </a>
    <span class="users_views">2571 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/1188"><span>Q.</span> Is it permissable to have ones bed facing the qiblah? Is it proven in any hadith that our feet should not face the qiblah? </a>
    <span class="users_views">12276 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/49645"><span>Q.</span> Wiping over socks </a>
    <span class="users_views">2662 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/38418"><span>Q.</span> I have masturbated for about more than 8 years. I have quitted it since last 2 years. Today my age is 20 </a>
    <span class="users_views">4933 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/35782"><span>Q.</span> When my penis activates due to some reason, and when it comes in to normal position, some very small drops of ejaculation (pre-seminal fluid, or little bit one drop of liquid) comes out </a>
    <span class="users_views">4096 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/19007"><span>Q.</span> Is it permissible to use Spirit or Swabs made of Alcohol before taking an injection? A diabetic patient has to take the same twice a day. Is it ok to use Alcoholic swabs? </a>
    <span class="users_views">1914 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/21123"><span>Q.</span> 1)i always doubt and feel like some urine has passed out and i keep thinking over that and try and wash my legs and clothes just on a feeling that some urine passed, plz help! 2) are the splashes off the bathroom floor napaak when we bath? what to do if they come on our body or clothes? 3) while doing istinja, water splashes off our private parts and the mug being used if comes on our clothes, do they get napaak? pleas help me from my doubts! </a>
    <span class="users_views">35054 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/62015"><span>Q.</span> Urine dripping and gas problem </a>
    <span class="users_views">3394 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/38589"><span>Q.</span> When I do potty (pakhana) while doing some force to do it I see that some drops of semen comes out from my penis </a>
    <span class="users_views">6819 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/60621"><span>Q.</span> Ghusl janabah and wuzu </a>
    <span class="users_views">2912 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/148007"><span>Q.</span> Issues of urine drops </a>
    <span class="users_views">3328 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/131076"><span>Q.</span> Stool/feces and urine leaking </a>
    <span class="users_views">8824 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/57214"><span>Q.</span> taharah </a>
    <span class="users_views">1394 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/58870"><span>Q.</span> Requesting for cure from light of Quran </a>
    <span class="users_views">1974 views</span>
    </li>
    <li><a href="https://darulifta-deoband.com/home/en/taharah-purity/14381"><span>Q.</span> Asslamwalaikum brother suppose if i dont change bedsheet after having sex with my wife and next day bed sheet goes dry automatically and i sleep on the same bed sheet and am fully paak but bed sheet was not paak, so am i paak for namaaz or i have make ghusal? </a>
    <span class="users_views">16922 views</span>
    </li>
    </ul>
    </div>
    </div>
    </div>
    </div>
    </div>
    </div>
    </div>
    </div>
    </div>
    </div> <div class="footer_text">
    </div>
    <div class="footer_deep_green">
    <div class="site_wapp">
    <div class="pull_left">2020 Ⓒ Darul Ifta - Darul Uloom Deoband, India<Br>
    Use of this website signifies your agreement to the <a href="https://darulifta-deoband.com/en/terms">Terms of Use</a>
    </div>
    <div class="pull_right">
    </div>
    <br class="clear" />
    </div>
    </div>
    </div>
    <script type="af4e0e11a4546cdbc357526b-text/javascript">
    	/*
    	${'$'}( document ).ready(function() {
    		${'$'}('.header__language-bar').hide();
    		${'$'}('.language-toggle').click(function(){
    			${'$'}('.header__language-bar').slideToggle();
    		})
    	})
    	*/
    	</script>
    <script type="af4e0e11a4546cdbc357526b-text/javascript">
    function googleTranslateElementInit() {
    document.getElementById("google_translate_element").innerHTML = "";
    new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages: 'en,ur,hi', autoDisplay: false}, 'google_translate_element');
    }
    </script>
    <script type="af4e0e11a4546cdbc357526b-text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit" defer="defer"></script>

    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-2089511-2" type="af4e0e11a4546cdbc357526b-text/javascript"></script>
    <script type="af4e0e11a4546cdbc357526b-text/javascript">
      window.dataLayer = window.dataLayer || [];
      function gtag(){dataLayer.push(arguments);}
      gtag('js', new Date());

      gtag('config', 'UA-2089511-2');
    </script>

    <script type="af4e0e11a4546cdbc357526b-text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5f38a06be154a914"></script>
    <script src="/cdn-cgi/scripts/7d0fa10a/cloudflare-static/rocket-loader.min.js" data-cf-settings="af4e0e11a4546cdbc357526b-|49" defer></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/vcd15cbe7772f49c399c6a5babf22c1241717689176015" integrity="sha512-ZpsOmlRQV6y907TI0dKBHq9Md29nnaEIPlkf84rnaERnq6zvWvPUqr2ft8M1aS28oN72PdrCzSjY4U6VaAw1EQ==" data-cf-beacon='{"rayId":"8ad3b6127ebb3188","version":"2024.7.0","r":1,"token":"035447eb9d884d11bc561797e36a9e82","serverTiming":{"name":{"cfL4":true}}}' crossorigin="anonymous"></script>
    </body>
    </html>

""".trimIndent()