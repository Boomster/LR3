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

	let max_pages = get_page_count();
	if(page_num > max_pages)
		page_num = 1;
	add_page_buttons(max_pages, page_num);
	add_catalog_items(page_num);
}

function add_page_buttons(max_pages, active_page)
{
	let page_list = document.querySelector(".page_list")
	for(let i = 1; i <= max_pages; i++)
	{
		let page_elem = document.createElement("a");
		page_list.appendChild(page_elem);
		page_elem.setAttribute("href", "catalog.html?p=" + i);
		page_elem.innerHTML=i;
		if(i == active_page)
		{
			page_elem.classList.add("active");
		}
	}
}

function get_page_count()
{
	return 3;
}

function add_catalog_items(page)
{
	let items_area = document.querySelector(".items");

	let items_info = get_catalog_page(page);
	items_info.forEach((item_info) =>{
		items_area.appendChild(create_catalog_item(item_info));
	});
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
	cost.innerHTML = info.cost + "р";
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

function get_catalog_page(page)
{
	let item = {};
	item.id = 1;
	item.name = "Doom Eternal";
	item.cost = 2000;
	item.image_link = "source/doom_eternal.jpg";
	
	let item2 = {};
	item2.id = 2;
	item2.name = "Doom Eternal 2";
	item2.cost = 666;
	item2.image_link = "source/doom_eternal.jpg";

	let items = [item, item2, item, item2, item, item2, item, item2, item];
	return items;
}