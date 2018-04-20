package scaffoldreact

import com.scaffoldreact.scaffoldreact.mapper.ScaffoldViewsMapper

class BootStrap {

    ScaffoldViewsMapper scaffoldViewsMapper

    def init = { servletContext ->
        scaffoldViewsMapper.map()
    }
    def destroy = {
    }
}
