<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ajaxFunction/functions.js"></script>
<t:template>

	<div id="status"></div>
	<div class="panel-body">

		<form method="post" role="form" id="form_login"
			action="${pageContext.request.contextPath}/saveRegister.bnu">

			<div class="form-group">

				<div class="input-group">
					<div class="input-group-addon">
						<i class="entypo-user"></i>
					</div>

					<input type="text" class="form-control" name="username"
						placeholder="Username" />
				</div>

			</div>

			<div class="form-group">

				<div class="input-group">
					<div class="input-group-addon">
						<i class="entypo-key"></i>
					</div>

					<input type="password" class="form-control" name="password"
						placeholder="Password" />
				</div>

			</div>
			<input type="hidden" name="check" value="${check}" />
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block btn-login">
					<i class="entypo-login"></i> Register
				</button>
			</div>


		</form>

	</div>

</t:template>