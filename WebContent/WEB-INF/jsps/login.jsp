<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>


	<div class="panel-body">
		<h3 class="title">
			<a href="${pageContext.request.contextPath}/common/RegisterUser.bnu">
				Sign up</a>
		</h3>
		<form method="post" role="form" id="form_login"
			action="${pageContext.request.contextPath}/loginUser.bnu">

			<div class="form-group">

				<div class="input-group">
					<div class="input-group-addon">
						<i class="entypo-user"></i>
					</div>

					<input type="text" class="form-control" name="j_username"
						placeholder="Username" />
				</div>

			</div>

			<div class="form-group">

				<div class="input-group">
					<div class="input-group-addon">
						<i class="entypo-key"></i>
					</div>

					<input type="password" class="form-control" name="j_password"
						placeholder="Password" />
				</div>

			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block btn-login">
					<i class="entypo-login"></i> Login In
				</button>
			</div>


		</form>

	</div>

</t:template>