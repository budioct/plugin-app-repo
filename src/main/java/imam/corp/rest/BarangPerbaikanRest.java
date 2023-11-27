package imam.corp.rest;

import imam.corp.modules.barangperbaikan.BarangPerbaikanService;
import imam.corp.modules.barangperbaikan.DTO;
import imam.corp.rest.handler.RestResponse;
import imam.corp.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/bperbaikan")
public class BarangPerbaikanRest {

    @Autowired
    BarangPerbaikanService service;

    @GetMapping(
            path = "/fetch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.list<List<DTO.respBarangPerbaikan>> fetching(@RequestParam Map<String, Object> filter) {

        Page<DTO.respBarangPerbaikan> respBarangPerbaikans = service.fetch(filter);

        return RestResponse.list.<List<DTO.respBarangPerbaikan>>builder()
                .list(respBarangPerbaikans.getContent())
                .paging(RestResponse.restPagingResponse.builder()
                        .currentPage(respBarangPerbaikans.getNumber())
                        .totalPage(respBarangPerbaikans.getTotalPages())
                        .sizePage(respBarangPerbaikans.getSize())
                        .build())
                .status_code(Constants.OK)
                .message(Constants.ITEM_EXIST_MESSAGE)
                .build();

    }

    @GetMapping(
            path = "detail/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangPerbaikan> detail(@PathVariable(name = "id") Long id) {

        DTO.respBarangPerbaikan respBarangPerbaikan = service.detail(id);

        return RestResponse.object.<DTO.respBarangPerbaikan>builder()
                .data(respBarangPerbaikan)
                .status_code(Constants.OK)
                .message(Constants.ITEM_EXIST_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangPerbaikan> create(@RequestBody DTO.reqstBarangPerbaikan request) {

        DTO.respBarangPerbaikan respBarangPerbaikan = service.create(request);

        return RestResponse.object.<DTO.respBarangPerbaikan>builder()
                .data(respBarangPerbaikan)
                .status_code(Constants.OK)
                .message(Constants.CREATE_MESSAGE)
                .build();

    }

    @PutMapping(
            path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangPerbaikan> update(@PathVariable(name = "id") Long id,
                                                               @RequestBody DTO.reqstUpdtBarangPerbaikan request) {

        request.setId(id);
        DTO.respBarangPerbaikan respBarangPerbaikan = service.update(request);

        return RestResponse.object.<DTO.respBarangPerbaikan>builder()
                .data(respBarangPerbaikan)
                .status_code(Constants.OK)
                .message(Constants.UPDATE_MESSAGE)
                .build();

    }

    @DeleteMapping(
            path = "/remove/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<String> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);

        return RestResponse.object.<String>builder()
                .data("")
                .status_code(Constants.OK)
                .message(Constants.DELETE_MESSAGE)
                .build();

    }


}
