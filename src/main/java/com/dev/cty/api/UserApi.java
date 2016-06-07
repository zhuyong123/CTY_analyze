package com.dev.cty.api;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dev.cty.api.exceptions.BadRequestException;
import com.dev.cty.dto.UserDto;
import com.dev.cty.entity.MobileUser;
import com.dev.cty.service.PropertyService;
import com.dev.cty.type.ErrorType;
import com.dev.cty.type.UserType;
import com.dev.cty.utils.ConstantUtils;
import com.dev.cty.utils.InitParameters;
import com.dev.cty.utils.MediumUtils;
import com.dev.cty.vo.UsersVo;

@Controller
@RequestMapping("/users")
public class UserApi extends BaseApi {
	@Autowired
	private PropertyService propertyService;
	
	private final Long MAX_TIME= 5*60*1000L;
	static final Logger logger = LoggerFactory.getLogger(UserApi.class);

	/**
	 * 用户注册
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> registerAccount(@RequestBody UserDto dto) {
//		if(dto.checkParamIsNull(dto.getUsername())){
//			throw new BadRequestException(ErrorType.ACCOUNT_USERNAME_ISNULL);
//		}
//		MobileUser user = dto.toObject(new MobileUser());
////		MobileUser userAcc = userService.getByAccount(user);
//		if(userAcc != null){ //账号是否存在
//			throw new BadRequestException(ErrorType.ACCOUNT_USERNAME_EXIST);
//		}
//		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
//		user.setUserTypeId(UserType.MOBILE_USER.ordinal());
//		if(StringUtils.isNotEmpty(dto.getRoomNo())){
//			String[] str=dto.getRoomNo().split("-");
//			if(str.length==3){
//				user.setFloorCode(str[0]);
//				user.setUnitCode(str[1]);
//				user.setHomeCode(str[2]);
//			}
//		}
////		userService.save(user);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	/**
	 * logout
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> logOut(@RequestBody UserDto dto) {
//		int row = userService.logOut(dto);
//		if(row>0){
//			return new ResponseEntity<Object>(HttpStatus.OK);
//		}else{
//			throw new BadRequestException(ErrorType.ACCOUNT_NOT_EXIST);
//		}
		return null;
	}
	
	/**
	 * 编辑个人资料
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Object> editUserInfo(
			@PathVariable(value = "userId") Long userId,
			@RequestBody UserDto dto) {
		MobileUser user = userService.getById(userId);
		user = dto.toObject(user);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/**
	 * 根据项目部ID查下面的员工
	 * @param userId
	 * @param departmentId
	 * @return
	 */
	@RequestMapping(value = "/{userId}/UserByDepartment", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> getUserByDepartment(
			@PathVariable(value = "userId") Long userId,
			@RequestParam(required = true) String departmentId) {
//		List<MobileUser> users = userService.getUserByDepartment(departmentId,userId);
//		UsersVo usersVo = new UsersVo(users);
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
	
}