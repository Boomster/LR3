function add_to_basket(item_id)
{
    alert("added " + item_id + " to basket");
}

function init_catalog()
{
	const query = window.location.search;
	const params = new URLSearchParams(query);

	let page = params.get("p");
	let page_num = 1;
	if(page && !isNaN(page)) // if page is a number
	{
		p = +page; //convert string to int
		if(Number.isInteger(p))
		{
			page_num = p;
		}
	}
	add_page_buttons(page_num);
	add_catalog_items(page_num);
}

async function add_page_buttons(active_page)
{
	let max_pages = await get_page_count();
	let page_list = document.querySelector(".page_list")
	for(let i = 1; i <= max_pages; i++)
	{
		let page_elem = document.createElement("a");
		page_list.appendChild(page_elem);
		page_elem.setAttribute("onclick", "ajax_reload(" + i + ")");
		page_elem.innerHTML=i;
		if(i == active_page)
		{
			page_elem.classList.add("active");
		}
	}
}

async function add_catalog_items(page)
{
	let items_area = document.querySelector(".items");

	let items_info = await get_catalog_page(page);
	items_info.forEach((item_info) =>{
		items_area.appendChild(create_catalog_item(item_info));
	});
}

function ajax_reload(page)
{
    let items = document.querySelectorAll(".items .item");
    items.forEach((item) => item.remove());
    add_catalog_items(page);
    let pages = document.querySelectorAll(".page_list a");
    pages.forEach((page) =>page.remove());
    add_page_buttons(page)
}

function create_catalog_item(info)
{
	let item = document.createElement("div");
	item.classList.add("item");
	
	let link = document.createElement("a");
	link.setAttribute("href", "item_description.html?i="+info.id);
	item.appendChild(link);

	let image = document.createElement('img');
	image.classList.add("itemimage");
	image.setAttribute("src", info.image_link);
	link.appendChild(image);

	let body = document.createElement("div");
	body.classList.add("itembody");
	item.appendChild(body);

	let name = document.createElement("div");
	name.classList.add("itemname");
	name.innerHTML = info.name;
	body.appendChild(name);

	let item_info = document.createElement("div");
	item_info.classList.add("iteminfo");
	body.appendChild(item_info);

	let cost = document.createElement("div");
	cost.classList.add("costtext");
	cost.innerHTML = info.price + "р";
	item_info.appendChild(cost);

	let button = document.createElement("div");
	button.classList.add("button");
	item_info.appendChild(button);

	let basket = document.createElement("a");
	basket.innerHTML="Add to Basket";
	basket.setAttribute("onClick", "add_to_basket(" + info.id + ")");
	button.appendChild(basket);

	return item;
}

async function get_catalog_page(page)
{
	let index = (page - 1) * 9;
    let items = fetch("http://localhost:8080/api/items/start/" + index)
    .then(res=>{
        return res.json();
    })
    .then(data =>{
        let items = []
        data.forEach(item=> items.push(item))
        return items;
    })
    return items;
}

async function get_page_count()
{
	let res = await fetch("http://localhost:8080/api/items/count");
	let num = await res.json();
	page_count = Math.ceil(num / 9)

	return page_count;
}