// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import "@openzeppelin/contracts/access/Ownable.sol";
import "base64-sol/base64.sol";

contract ProductNFT is ERC721, Ownable {
    uint256 public nextTokenId;

    struct ProductInfo {
        string manufactureDate;
        string collectionName;
        uint8 rarityPercentage;
    }

    mapping(uint256 => ProductInfo) private _productInfo;

    constructor() ERC721("ProductNFT", "PNFT") {}

    function mint(
        address to,
        string memory manufactureDate,
        string memory collectionName,
        uint8 rarityPercentage
    ) external onlyOwner {
        uint256 tokenId = nextTokenId;
        _safeMint(to, tokenId);

        // Metadata bilgilerini kaydet
        _productInfo[tokenId] = ProductInfo({
            manufactureDate: manufactureDate,
            collectionName: collectionName,
            rarityPercentage: rarityPercentage
        });
        nextTokenId++;
    }

    // Transfer işlemlerini sadece owner yapabilir
    function _isApprovedOrOwner(address spender, uint256 tokenId) internal view override returns (bool) {
        return (owner() == spender); // Sadece sözleşme sahibi transfer edebilir
    }

    // Kullanıcıların transfer etmesini engellemek için safeTransferFrom fonksiyonlarını override ediyoruz
    function safeTransferFrom(address from, address to, uint256 tokenId) public override onlyOwner {
        super.safeTransferFrom(from, to, tokenId);
    }

    function safeTransferFrom(address from, address to, uint256 tokenId, bytes memory _data) public override onlyOwner {
        super.safeTransferFrom(from, to, tokenId, _data);
    }

    function transferFrom(address from, address to, uint256 tokenId) public override onlyOwner {
        super.transferFrom(from, to, tokenId);
    }

    function tokenURI(uint256 tokenId) public view override returns (string memory) {
        require(_exists(tokenId), "ERC721Metadata: URI query for nonexistent token");

        ProductInfo memory product = _productInfo[tokenId];

        string memory json = Base64.encode(bytes(string(abi.encodePacked(
            '{"name": "Product NFT #', uint2str(tokenId), '",',
            '"description": "This NFT represents a unique product from the collection.',
            '"manufacture_date": "', product.manufactureDate, '",',
            '"collection_name": "', product.collectionName, '",',
            '"rarity_percentage": "', uint2str(product.rarityPercentage), '%"}'
        ))));

        return string(abi.encodePacked("data:application/json;base64,", json));
    }

    function uint2str(uint256 _i) internal pure returns (string memory str) {
        if (_i == 0) {
            return "0";
        }
        uint256 j = _i;
        uint256 len;
        while (j != 0) {
            len++;
            j /= 10;
        }
        bytes memory bstr = new bytes(len);
        uint256 k = len;
        while (_i != 0) {
            k = k - 1;
            uint8 temp = (48 + uint8(_i - (_i / 10) * 10));
            bytes1 b1 = bytes1(temp);
            bstr[k] = b1;
            _i /= 10;
        }
        str = string(bstr);
    }

    function getProductInfo(uint256 tokenId) public view returns (
        string memory manufactureDate,
        string memory collectionName,
        uint8 rarityPercentage
    ) {
    require(_exists(tokenId), "ERC721Metadata: Query for nonexistent token");

    ProductInfo memory product = _productInfo[tokenId];

    return (
        product.manufactureDate,
        product.collectionName,
        product.rarityPercentage
    );
    }
}