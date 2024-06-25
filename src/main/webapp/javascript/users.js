function checkEmail(event) {
	//이벤트 발생 객체
	const obj = event.target;	//	button#check-email
	const target = obj.getAttribute("data-target");	//	API 호출 위
	const frm = obj.form;	//	폼
	
	const email = frm.email.value.trim();
	
	if(email.length === 0) {
		alert("이메일을 입력하세요오..");
		return;
	}
	
	//fetch
	fetch(`${target}?email=${email}`).then(response => {
		console.log(response);
		return response.json();
	})
	.then(json => {
		console.log(json);
		//중복 여부 판단하자.
		if(json.exists) {
			alert('이미 사용중인 이메일인데요?')
			throw new Error('중복된 이메일!!')
		} else {
			alert('사용가능한 이메일!');
			frm.emailCheck.value = "y";
		}
	}).catch(error => console.error(error))
}

window.addEventListener("load", event => {
	document.getElementById("check-email").addEventListener("click", checkEmail);
	
	//	가입 폼 Validation
document.getElementById("join-form").addEventListener("submit", event => {
	
	const frm = event.target;
	
	event.preventDefault();
	
	//	이름 검증
	if (frm.name.value.trim().length === 0) {
		alert('이름 없는 자 ');
		frm.name.forcus();
		return;
	}
	
	//	비밀번호 검증
	if (frm.password.value.trim().length === 0) {
		alert('비밀번호 적어요');
		frm.password.forcus();
		return;
	}
	
	//	이메일 검증
	if (frm.email.value.trim().length === 0) {
		alert('이메일 잘 적어보세여ㅛ');
		frm.email.forcus();
		return;
	}
	
	//	성별?
	const genders = document.querySelector("input[name=gender]:checked");
	
	if (genders === null) {
		alert('LGBT');
		return;
	}
	
	//	이메일 중복 체크 여부
	if (frm.emailCheck.value !== 'y') {
		alert('이메일 중복 체크 눌러봐');
		return;
	}
	
	//	약관 동의 여부
	if (!frm.agree.checked){
		alert('약관에 동의하여라');
		return;
	}
	
	//	전송
	frm.submit();
	
})
	
});

