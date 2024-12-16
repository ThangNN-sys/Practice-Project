package com.vti.controller;

import com.vti.dto.account.AccountDTO;
import com.vti.dto.account.DepartmentDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.account.AccountFilterForm;
import com.vti.form.account.CreatingAccountForm;
import com.vti.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A REST controller that provides various endpoints for managing accounts and departments.
 * It supports operations to retrieve, create, and delete accounts,
 * as well as querying departments for search functionality.
 */
@RestController // cung cấp các API REST, trả về dữ liệu JSON hoặc XML
@RequestMapping(value = "api/v1/accounts") // Mọi endpoint đều bắt đầu với api/v1/accounts
public class AccountController {

    @Autowired // Inject các bean (đối tượng được quản lý bởi Spring) vào controller
    private ModelMapper modelMapper; // ModelMapper: Để chuyển đổi giữa entity và DTO

    @Autowired
    private IAccountService service; // IAccountService: Dịch vụ xử lý logic nghiệp vụ liên quan đến Account

	// @GetMapping(): Định nghĩa một API HTTP GET để lấy danh sách tài khoản
	// Pageable pageable: Nhận thông tin phân trang từ client (số trang, kích thước trang)
	// @RequestParam(value = "search", required = false): Lấy tham số search từ query string (tùy chọn).
	// AccountFilterForm: Nhận thông tin lọc từ client.
	// Logic:
	// Lấy danh sách Account từ service (entity dạng Page<Account>).
	// Chuyển đổi danh sách entity sang DTO (List<AccountDTO>) bằng ModelMapper.
	// Tạo Page<AccountDTO> trả về cho client.
	@GetMapping()
    public Page<AccountDTO> getAllAccounts(Pageable pageable,
										   @RequestParam(value = "search", required = false) String search, AccountFilterForm filterForm) {

        Page<Account> entityPages = service.getAllAccounts(pageable, search, filterForm);

        // convert entities --> dtos
        List<AccountDTO> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<AccountDTO>>() {
        }.getType());

        Page<AccountDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

        return dtoPages;

    }

	// Tương tự Account.
    @GetMapping("/departments")
    public Page<DepartmentDTO> getAllDepartmentsForSearch(Pageable pageable,
														  @RequestParam(value = "search", required = false) String search) {

        Page<Department> entityPages = service.getAllDepartmentsForSearch(pageable, search);

        // convert entities --> dtos
        List<DepartmentDTO> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<DepartmentDTO>>() {
        }.getType());

        Page<DepartmentDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

        return dtoPages;

    }

	// @PostMapping(): Định nghĩa API HTTP POST để tạo mới tài khoản
	// @RequestBody CreatingAccountForm form: Nhận dữ liệu từ body của request để tạo tài khoản
	// Gọi service thực hiện logic tạo tài khoản.
    @PostMapping()
    public void createAccount(@RequestBody CreatingAccountForm form) {
        service.createAccount(form);
    }

	// @GetMapping("/username/{username}/exists"): Kiểm tra xem tài khoản với username cụ thể có tồn tại hay không
	// @PathVariable(name = "username"): Lấy username từ URL
	// Trả về true/false dựa trên kết quả từ service.
    @GetMapping(value = "/username/{username}/exists")
    public boolean existsByName(@PathVariable(name = "username") String username) {
        return service.isAccountExistsByUserName(username);
    }

	// @DeleteMapping("/{id}"): Định nghĩa API HTTP DELETE để xóa tài khoản theo ID
	// @PathVariable(name = "id"): Lấy ID từ URL
	// Gọi service thực hiện xóa tài khoản.
    @DeleteMapping(value = "/{id}")
    public void deleteAccount(@PathVariable(name = "id") int id) {
        service.deleteAccount(id);
    }

	// @DeleteMapping: API xóa nhiều tài khoản dựa trên danh sách ID
	// @RequestParam(name = "ids"): Lấy danh sách ID từ query string (vd: ?ids=1,2,3)
	// Gọi service để xóa nhiều tài khoản.
    @DeleteMapping
    public void deleteAccounts(@RequestParam(name = "ids") List<Integer> ids) {
        service.deleteAccounts(ids);
    }


}
