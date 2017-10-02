<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<!-- Mirrored from themes.laborator.co/neon/dashboard/main/ by HTTrack Website Copier/3.x [XR&CO'2013], Tue, 01 Apr 2014 21:39:35 GMT -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="Neon Admin Panel" />
<meta name="author" content="Laborator.co" />

<title>HMSS</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css"
	id="style-resource-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-icons/entypo/css/entypo.css"
	id="style-resource-2">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic"
	id="style-resource-3">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-min.css"
	id="style-resource-4">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/neon-core-min.css"
	id="style-resource-5">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/neon-theme-min.css"
	id="style-resource-6">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/neon-forms-min.css"
	id="style-resource-7">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom-min.css"
	id="style-resource-8">

<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>
<script>
	$.noConflict();
</script>

<!--[if lt IE 9]><script src="http://themes.laborator.co/neon/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->


<!-- TS1396388379: Neon - Responsive Admin Template created by Laborator -->
</head>
<body class="page-body  page-fade"
	data-url="http://themes.laborator.co/neon">
	<div class="page-container">

		<div id="navbar">
			<%@include file="/WEB-INF/mainJsp's/Navbar.jsp"%>
		</div>
		<div id="header">
			<%@include file="/WEB-INF/mainJsp's/header.jsp"%>
		</div>
		<div class="main-content">

			<jsp:doBody />

		</div>

		<div id="footer">
			<%@include file="/WEB-INF/mainJsp's/footer.jsp"%>
		</div>
	</div>
	<!-- /.row -->


	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/js/jvectormap/jquery-jvectormap-1.2.2.css"
		id="style-resource-1">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/js/rickshaw/rickshaw.min.css"
		id="style-resource-2">

	<script
		src="${pageContext.request.contextPath}/resources/js/gsap/main-gsap.js"
		id="script-resource-1"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"
		id="script-resource-2"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"
		id="script-resource-3"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/joinable.js"
		id="script-resource-4"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/resizeable.js"
		id="script-resource-5"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/neon-api.js"
		id="script-resource-6"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/cookies.min.js"
		id="script-resource-7"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jvectormap/jquery-jvectormap-1.2.2.min.js"
		id="script-resource-8"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jvectormap/jquery-jvectormap-europe-merc-en.js"
		id="script-resource-9"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.sparkline.min.js"
		id="script-resource-10"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/rickshaw/vendor/d3.v3.js"
		id="script-resource-11"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/rickshaw/rickshaw.min.js"
		id="script-resource-12"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/raphael-min.js"
		id="script-resource-13"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/morris.min.js"
		id="script-resource-14"></script>
	<script src="${pageContext.request.contextPath}/resources/js/toastr.js"
		id="script-resource-15"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/neon-chat.js"
		id="script-resource-16"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/neon-custom.js"
		id="script-resource-17"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/neon-demo.js"
		id="script-resource-18"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/neon-skins.js"
		id="script-resource-19"></script>
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-28991003-3' ]);
		_gaq.push([ '_setDomainName', 'laborator.co' ]);
		_gaq.push([ '_setAllowLinker', true ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
	<!-- 	</div> -->

</body>
</html>